package com.example.homework_m7_1.presentation.main_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.homework_m7_1.databinding.ItemCameraBinding
import com.example.homework_m7_1.data.models.DoorModel

class DoorAdapter() : Adapter<DoorAdapter.DoorViewHolder>() {
    private var list = listOf<DoorModel.Data>()

    fun setDataAdaoter(list: List<DoorModel.Data>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class DoorViewHolder(private val binding: ItemCameraBinding) : ViewHolder(binding.root) {

        fun bind(door: DoorModel.Data) {
            with(binding) {
                tv.text = door.name
                iv.load(door.snapshot)

                tv.setOnClickListener {
                    if (binding.iv.visibility == View.GONE) {
                        iv.visibility = View.VISIBLE
                    } else if (binding.iv.visibility == View.VISIBLE){
                        iv.visibility == View.GONE
                    }
                }
            }
        }
    }
}