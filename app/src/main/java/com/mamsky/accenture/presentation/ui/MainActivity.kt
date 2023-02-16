package com.mamsky.accenture.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.mamsky.accenture.R
import com.mamsky.accenture.base.BaseActivity
import com.mamsky.accenture.databinding.ActivityMainBinding
import com.mamsky.accenture.presentation.MainViewModel
import com.mamsky.accenture.presentation.adapter.HomeTabAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPageAdapter()
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()

        viewModel.getUsers().observe(this) {
            it?.let {
                it.forEach { x -> printLog("data ${x.login}") }
            }
        }
    }

    private fun initPageAdapter() {
        with(getViewBinder()) {
            val sectionPagerAdapter = HomeTabAdapter(supportFragmentManager, lifecycle)
            viewPager.adapter = sectionPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                printLog("OnTabSelect $pos ${tab.isSelected}")
                tab.text = when (pos) {
                    0 -> "Popular"
                    else -> "Favorite"
                }
            }.attach()
        }
    }

    override fun printLog(msg: String) {
        println("MainActivity: $msg")
    }

}