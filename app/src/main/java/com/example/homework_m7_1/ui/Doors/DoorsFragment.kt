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
import com.example.homework_m7_1.base.BaseFragment
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.databinding.FragmentDoorsBinding
import com.example.homework_m7_1.ui.main_fragment.adapter.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : BaseFragment() {

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

        viewModel.getDoors().stateHandler(
            success = { adapter.submitList(it.data) }
        )
        binding.rvDoors.adapter = adapter
    }


}