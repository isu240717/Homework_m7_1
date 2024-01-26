package com.example.homework_m7_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_m7_1.databinding.FragmentCameraBinding


class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCameraBinding

    private var list = arrayListOf<ItemModel>(
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 1"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 2"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 3"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 4"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 1"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 2"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 3"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Camera 4"
        ),
    )

    private val adapter = RecyclerAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCameras.adapter = adapter
    }

}