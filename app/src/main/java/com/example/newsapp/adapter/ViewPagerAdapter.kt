package com.example.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.fragment.*

const val TABS_NUMS = 6
class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_NUMS
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> GeneralFragment()
            1-> SportFragment()
            2-> ScienceFragment()
            3-> TechFragment()
            4-> EntertainmentFragment()
            else -> BusinessFragment()
        }
    }
}