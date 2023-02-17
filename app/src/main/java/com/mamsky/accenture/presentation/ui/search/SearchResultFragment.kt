package com.mamsky.accenture.presentation.ui.search

import com.mamsky.accenture.R
import com.mamsky.core.base.BaseFragment
import com.mamsky.accenture.databinding.FragmentUserListBinding
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