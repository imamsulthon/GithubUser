package com.mamsky.githubuser.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mamsky.githubuser.presentation.ui.favorite.FavoriteFragment
import com.mamsky.githubuser.presentation.ui.popular.PopularUserFragment

class HomeTabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: List<Fragment>? = null,
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (fragments.isNullOrEmpty()) {
            when (position) {
                0 -> PopularUserFragment()
                1 -> FavoriteFragment()
                else -> PopularUserFragment()
            }
        } else {
            fragments[position]
        }
    }

}