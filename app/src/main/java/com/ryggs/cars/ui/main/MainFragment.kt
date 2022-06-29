package com.ryggs.cars.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ryggs.cars.R
import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.allcarsfeature.presentation.AllCarsEvent
import com.ryggs.cars.allcarsfeature.presentation.AllCarsViewModel
import com.ryggs.cars.allcarsfeature.presentation.AllCarsViewState
import com.ryggs.cars.allcarsfeature.presentation.CarsAdapter
import com.ryggs.cars.cardetailfeature.presentation.CarDetailViewModel
import com.ryggs.cars.core.presentation.Event
import com.ryggs.cars.databinding.FragmentMainBinding
import com.ryggs.cars.popularmakesfeature.presentation.AllCarCategoryEvent
import com.ryggs.cars.popularmakesfeature.presentation.AllCarCategoryViewModel
import com.ryggs.cars.popularmakesfeature.presentation.AllCarCategoryViewState
import com.ryggs.cars.popularmakesfeature.presentation.CarPopularCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainFragment : Fragment() {

    private val allCarsViewModel : AllCarsViewModel by viewModels()
    private val allCarCategoryViewModel : AllCarCategoryViewModel by viewModels()
    private val carDetailViewModel : CarDetailViewModel by viewModels()

    private val adapter by lazy { CarsAdapter { item ->
        showCarDetails(item as UIAllCars)
    }
    }

    private fun showCarDetails(carDetailResponse: UIAllCars) {
        // TODO: find a better way to do this (navigate), because this is an event, it should be treated as such probably in the vm
        Toast.makeText(requireContext(), "id: ${carDetailResponse.id}", Toast.LENGTH_SHORT).show()
        // val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(carDetailResponse.id)
        val bundle = bundleOf("id" to carDetailResponse.id)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        requestInitialCarList()
    }

    private fun requestInitialCarList() {
        allCarCategoryViewModel.onEvent(AllCarCategoryEvent.RequestInitialCarsList)
        allCarsViewModel.onEvent(AllCarsEvent.RequestInitialCarsList)
    }

    private fun setupUI() {
        val categoryAdapter = CarPopularCategoryAdapter()
        setupAllCarsRecyclerView(adapter, categoryAdapter)
        observeViewStateUpdates(adapter, categoryAdapter)
    }

    // TODO: ind better ways to handle this sort of repeatition
    private fun setupAllCarsRecyclerView(
        carAdapter: CarsAdapter,
        categoryAdapter: CarPopularCategoryAdapter
    ) {
        binding.category.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            setHasFixedSize(true)
            // addOnScrollListener(createInfiniteScrollListener(layoutManager as GridLayoutManager))
        }
        binding.cars.apply {
            adapter = carAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            setHasFixedSize(true)
            // addOnScrollListener(createInfiniteScrollListener(layoutManager as GridLayoutManager))
        }
    }

    private fun observeViewStateUpdates(
        adapter: CarsAdapter,
        categoryAdapter: CarPopularCategoryAdapter
    ) {
        allCarCategoryViewModel.state.observe(viewLifecycleOwner) {
            updateCategoryScreenState(it, categoryAdapter)
        }
        allCarsViewModel.state.observe(viewLifecycleOwner) {
            updateScreenState(it, adapter)
        }
    }

    private fun updateCategoryScreenState(
        allCarsViewState: AllCarCategoryViewState,
        categoryAdapter: CarPopularCategoryAdapter
    ) {
        binding.progressBar.isVisible = allCarsViewState.loading
        categoryAdapter.submitList(allCarsViewState.cars)
        handleFailures(allCarsViewState.failure)
    }

    private fun updateScreenState(
        allCarsViewState: AllCarsViewState,
        adapter: CarsAdapter
    ) {
        binding.progressBar.isVisible = allCarsViewState.loading
        adapter.submitList(allCarsViewState.cars)
        handleFailures(allCarsViewState.failure)
    }

    private fun handleFailures(failure: Event<Throwable>?) {
        val unhandledFailure = failure?.getContentIfNotHandled() ?: return

        val fallbackMessage = getString(R.string.error)

        val toastMessage = if (unhandledFailure.message.isNullOrEmpty()) {
            fallbackMessage
        } else {
            unhandledFailure.message!!
        }

        if (toastMessage.isNotEmpty()) {
            Snackbar.make(requireView(), toastMessage, Snackbar.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Error: $failure", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}