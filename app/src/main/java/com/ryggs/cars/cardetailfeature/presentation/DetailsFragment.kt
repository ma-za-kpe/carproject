package com.ryggs.cars.cardetailfeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ryggs.cars.R
import com.ryggs.cars.databinding.FragmentDetailsBinding
import com.ryggs.cars.databinding.FragmentMainBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString("id")
        Toast.makeText(requireContext(), "id in details is ${arguments?.getString("id")}", Toast.LENGTH_SHORT).show()
    }
}