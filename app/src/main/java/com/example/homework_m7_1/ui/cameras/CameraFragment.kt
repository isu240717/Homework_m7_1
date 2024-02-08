package com.example.homework_m7_1.ui.cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework_m7_1.base.BaseFragment
import com.example.homework_m7_1.databinding.FragmentCameraBinding
import com.example.homework_m7_1.ui.main_fragment.adapter.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : BaseFragment() {
    private lateinit var binding: FragmentCameraBinding
    private val viewModel: CameraViewModel by viewModels()

    private val adapter = RecyclerAdapter(false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCameras.adapter = adapter

        binding.swiperefresh.setOnRefreshListener {
            viewModel.getCameras().stateHandler(
                success = {
                    adapter.submitList(it.data.cameras)
                    binding.swiperefresh.isRefreshing = false
                }
            )
        }
        viewModel.getCameras().stateHandler(
            success ={
                adapter.submitList(it.data.cameras)
            }
        )

    }

}