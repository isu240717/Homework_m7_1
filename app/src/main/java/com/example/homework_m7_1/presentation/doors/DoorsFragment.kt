package com.example.homework_m7_1.presentation.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework_m7_1.base.BaseFragment
import com.example.homework_m7_1.databinding.FragmentDoorsBinding
import com.example.homework_m7_1.presentation.main_fragment.adapter.DoorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : BaseFragment() {

    private lateinit var binding: FragmentDoorsBinding
    private val viewModel: DoorViewModel by viewModels()

    private val adapter = DoorAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDoors.adapter = adapter
        binding.swiperefresh.setOnRefreshListener {
            viewModel.getDoors().stateHandler(
                success = {
                    adapter.setDataAdaoter(it.data)
                    binding.swiperefresh.isRefreshing = false
                }
            )
        }
        viewModel.getDoors().stateHandler(
            success = {
                adapter.setDataAdaoter(it.data)
            }
        )

    }


}