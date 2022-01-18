package com.example.hamakeja.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.ktx.R
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hamakeja.fragments.HomeFragment
import com.example.hamakeja.fragments.TruckOwnerFragment
import com.example.hamakeja.fragments.WantToMoveFragment


class SectionsPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TruckOwnerFragment()
            1 -> HomeFragment()
            2 -> WantToMoveFragment()
            else -> HomeFragment()

        }
    }

}
