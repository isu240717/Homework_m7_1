package com.example.homework_m7_1.ui.Cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_m7_1.base.BaseFragment
import com.example.homework_m7_1.data.Resource
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

        viewModel.getCameras().stateHandler(
            success ={
                adapter.submitList(it.data.cameras)
            }
        )
        binding.rvCameras.adapter = adapter
    }

}