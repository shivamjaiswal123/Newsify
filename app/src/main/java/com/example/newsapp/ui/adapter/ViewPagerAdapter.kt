package com.example.newsapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.screens.fragment.BusinessFragment
import com.example.newsapp.ui.screens.fragment.EntertainmentFragment
import com.example.newsapp.ui.screens.fragment.GeneralFragment
import com.example.newsapp.ui.screens.fragment.ScienceFragment
import com.example.newsapp.ui.screens.fragment.SportFragment
import com.example.newsapp.ui.screens.fragment.TechFragment

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