package com.example.hamakeja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.hamakeja.databinding.ActivityHomeBinding
import com.example.hamakeja.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeActivity : AppCompatActivity() {
    var tabTitle = arrayOf("Owner", "Start", "I want to Move")
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        pager.adapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, pager) {
            tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        actionBar?.setSelectedNavigationItem(2)

    }
}