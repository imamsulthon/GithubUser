package com.mamsky.accenture.presentation.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mamsky.accenture.R
import com.mamsky.accenture.databinding.ActivityMainBinding
import com.mamsky.accenture.presentation.adapter.HomeTabAdapter
import com.mamsky.accenture.presentation.ui.favorite.FavoriteFragment
import com.mamsky.accenture.presentation.ui.popular.PopularUserFragment
import com.mamsky.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPageAdapter()
    }

    private fun initPageAdapter() {
        with(getViewBinder()) {
            val sectionPagerAdapter = HomeTabAdapter(supportFragmentManager, lifecycle, fragments)
            viewPager.adapter = sectionPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                selectedFragment = pos
                tab.text = when (pos) {
                    0 -> "Popular"
                    else -> "Favorite"
                }
            }.attach()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        if (it.isNotEmpty()) {
                            proceedSearch(it)
                            searchView.clearFocus()
                        } else {
                            searchView.clearFocus()
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean = false
            })

            searchView.setOnCloseListener { searchView.setQuery("", false)
                searchView.clearFocus()
                true
            }
        }
    }

    private val popularFrag = PopularUserFragment()
    private val favoriteFrag = FavoriteFragment()
    private var selectedFragment = 0
    private val fragments = listOf<Fragment>(
        popularFrag, favoriteFrag
    )


    private fun proceedSearch(query: String?) {
        if (selectedFragment == 0 && popularFrag.isVisible) {
            query?.let { popularFrag.onSearch(it) }
        } else if (selectedFragment == 1 && favoriteFrag.isVisible) {
            query?.let { favoriteFrag.onSearch(it) }
        }
    }

    override fun printLog(msg: String) {
        println("MainActivity: $msg")
    }

}