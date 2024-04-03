package com.example.homework_m7_1.presentation.main_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homework_m7_1.databinding.ItemCameraBinding
import com.example.homework_m7_1.data.models.CameraModel
import com.example.homework_m7_1.data.models.Data

class RecyclerAdapter(private val isDoor : Boolean) :
    ListAdapter<CameraModel.Data.Camera, RecyclerViewHolder>(CameraDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), isDoor

        )

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class RecyclerViewHolder(private var binding: ItemCameraBinding, private val isDoor: Boolean) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(camera: CameraModel.Data.Camera) = with(binding) {
        ivLock.visibility = if (isDoor) View.VISIBLE else View.GONE
        iv.load(camera.snapshot)
        tv.text = camera.name
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

class CameraDiffUtil : DiffUtil.ItemCallback<CameraModel.Data.Camera>() {
    override fun areItemsTheSame(oldItem: CameraModel.Data.Camera, newItem: CameraModel.Data.Camera)= oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: CameraModel.Data.Camera, newItem: CameraModel.Data.Camera) = oldItem == newItem

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