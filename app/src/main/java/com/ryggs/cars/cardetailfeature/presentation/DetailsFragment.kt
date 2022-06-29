package com.ryggs.cars.cardetailfeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ryggs.cars.allcarsfeature.presentation.CarDetailsEvent
import com.ryggs.cars.core.utils.setImage
import com.ryggs.cars.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val carDetailViewModel : CarDetailViewModel by viewModels()

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = carDetailViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = arguments?.getString("id")
        setupUI()
        requestInitialCarDetail(id)
    }

    private fun requestInitialCarDetail(id: String?) {
        carDetailViewModel.onEvent(CarDetailsEvent.RequestCarsDetail, id.toString())
    }

    private fun setupUI() {
        carDetailViewModel.state.observe(viewLifecycleOwner) {
            updateCarDetailScreenState(it)
        }
    }

    private fun updateCarDetailScreenState(it: CarDetailViewState) {
        binding.progressBar.isVisible = it.loading
        binding.carId.text = it.cars.name
        binding.carImage.setImage(it.cars.photo)
        Toast.makeText(requireContext(), "name of car ${it.cars.name}}", Toast.LENGTH_SHORT).show()

    }
}