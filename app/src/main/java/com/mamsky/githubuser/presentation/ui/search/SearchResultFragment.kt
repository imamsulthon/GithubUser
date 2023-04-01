package com.mamsky.githubuser.presentation.ui.search

import com.mamsky.githubuser.R
import com.mamsky.core.base.BaseFragment
import com.mamsky.githubuser.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment: BaseFragment<FragmentUserListBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_user_list

    override fun setContent() {
        super.setContent()
        with(getViewBinder()) {
            swipeRefresh.setOnRefreshListener {

            }
        }
    }

}