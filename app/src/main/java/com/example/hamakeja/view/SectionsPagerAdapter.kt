package com.example.hamakeja.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.viewmodel.ktx.R


private val TAB_TITLE = arrayOf(
    com.example.hamakeja.R.string.owner,
    com.example.hamakeja.R.string.start,
    com.example.hamakeja.R.string.want_to_move,


)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(2)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLE[position])
    }


}
