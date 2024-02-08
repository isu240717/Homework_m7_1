package com.example.homework_m7_1.ui.main_fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework_m7_1.ui.cameras.CameraFragment
import com.example.homework_m7_1.ui.doors.DoorsFragment

class ViewPagerAdapter(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        CameraFragment(), DoorsFragment()
    )
    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
       return when (position) {
            0 -> CameraFragment()
            1 -> DoorsFragment()
            else -> CameraFragment()
        }
    }
}