package com.example.homework_m7_1.ui.Doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.databinding.FragmentDoorsBinding
import com.example.homework_m7_1.ui.main_fragment.adapter.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : Fragment() {

    private lateinit var binding: FragmentDoorsBinding
    private val viewModel: DoorViewModel by viewModels()

    private val adapter = RecyclerAdapter(true)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDoors().observe(requireActivity()) {
            when (it) {
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    adapter.submitList(it.data)
                }
            }
            setupCharactersRecycler()
        }
    }

    private fun setupCharactersRecycler() = with(binding) {
        rvDoors.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        rvDoors.adapter = adapter
    }
}