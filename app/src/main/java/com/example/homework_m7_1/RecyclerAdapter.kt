package com.example.homework_m7_1

import android.animation.ValueAnimator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.homework_m7_1.databinding.ItemCameraBinding

class RecyclerAdapter(private var list: ArrayList<ItemModel>) : Adapter<RecuclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecuclerViewHolder {
        return RecuclerViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecuclerViewHolder, position: Int) {
        holder.bind(list[position])
    }

}

class RecuclerViewHolder(private var binding: ItemCameraBinding) : ViewHolder(binding.root) {

    fun bind(itemModel: ItemModel) = with(binding) {
        iv.load(itemModel.image)
        tv.text = itemModel.text
        tv.setOnClickListener {
            if (binding.iv.visibility == View.GONE) {
                slideOutViews(binding.iv)
            } else {
                slideInViews(binding.iv)
            }
        }
    }

    private fun slideOutViews(view: View) {
        val duration = 500L

        view.apply {
            visibility = View.VISIBLE
            translationY = -height.toFloat()

            animate()
                .translationY(0f)
                .setDuration(duration)
                .start()
        }
    }


    private fun slideInViews(view: View) {
        val duration = 500L

        view.apply {
            animate()
                .translationY(-height.toFloat())
                .setDuration(duration)
                .withEndAction {
                    visibility = View.GONE
                    translationY = 0f
                }
                .start()
        }
    }
}

/*    private lateinit var valueAnimator: ValueAnimator
    private fun animationUp() {
        valueAnimator = ValueAnimator.ofInt(0, -100)
        valueAnimator.duration = 500
        valueAnimator.addUpdateListener { animation ->
            val value: Int = animation.animatedValue as Int
            binding.iv.translationY = value.toFloat()
            binding.iv.visibility = View.VISIBLE
        }
        valueAnimator.start()
    }

    private fun animationDown() {
        valueAnimator = ValueAnimator.ofInt(0, 100)
        valueAnimator.duration = 500
        valueAnimator.addUpdateListener { animation ->
            val value: Int = animation.animatedValue as Int
            binding.iv.translationY = value.toFloat()
            binding.iv.visibility = View.GONE
        }
        valueAnimator.start()
    }
*/