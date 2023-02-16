package com.mamsky.accenture.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mamsky.accenture.presentation.ui.FavoriteFragment
import com.mamsky.accenture.presentation.ui.PopularUserFragment

class HomeTabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularUserFragment()
            1 -> FavoriteFragment()
            else -> PopularUserFragment()
        }
    }

}