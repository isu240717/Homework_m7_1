package com.example.homework_m7_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_m7_1.databinding.FragmentDoorsBinding

class DoorsFragment : Fragment() {

    private lateinit var binding: FragmentDoorsBinding

    private var list = arrayListOf<ItemModel>(
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 1"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 2"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 3"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 4"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 1"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 2"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 3"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 4"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 1"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 2"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 3"
        ),
        ItemModel(
            "https://gas-kvas.com/grafic/uploads/posts/2023-10/1696422784_gas-kvas-com-p-kartinki-milie-kotyat-43.jpg",
            "Door 4"
        ),
    )
    private val adapter = RecyclerAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorsBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDoors.adapter = adapter
    }

}