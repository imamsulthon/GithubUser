package com.mamsky.githubuser.presentation.ui.popular

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamsky.githubuser.R
import com.mamsky.githubuser.databinding.FragmentUserListBinding
import com.mamsky.githubuser.presentation.adapter.UserListAdapter
import com.mamsky.githubuser.presentation.ui.MainViewModel
import com.mamsky.githubuser.presentation.ui.detail.UserDetailActivity
import com.mamsky.core.base.BaseFragment
import com.mamsky.data.user.model.UserViewParam
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularUserFragment: BaseFragment<FragmentUserListBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private var job: Job? = null

    // improve with paging adapter
    private val adapter: UserListAdapter by lazy {
        UserListAdapter(listOf()) {
            startActivity(Intent(requireContext(), UserDetailActivity::class.java).apply {
                putExtra(UserDetailActivity.TAG_DATA, it)
            })
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_user_list

    override fun setContent() {
        super.setContent()
        viewModel.fetchList()
        with(getViewBinder()) {
            recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerview.adapter = adapter
            swipeRefresh.setOnRefreshListener {
                viewModel.fetchList()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()
        viewModel.getUsers().observe(viewLifecycleOwner) { list ->
            if (list.isNullOrEmpty()) {
                showEmptyState(true)
                return@observe
            }
            list.let {
                showEmptyState(false)
                setRecyclerView(it)
            }
        }

        viewModel.onError().observe(viewLifecycleOwner) {
            it?.let { showEmptyState(it) }
        }

        viewModel.onLoading().observe(viewLifecycleOwner) {
            it?.let {
                getViewBinder().swipeRefresh.isEnabled = !it
            }
        }
    }

    private fun setRecyclerView(list: List<UserViewParam>) {
        adapter.updateData(list)
    }

    fun onSearch(query: String) {
        job?.cancel()
        job = lifecycleScope.launch {
            delay(500)
            viewModel.search(query)
        }
        job?.start()
    }

    private fun showEmptyState(show: Boolean) {
        with(getViewBinder()) {
            if (show) {
                emptyState.layoutEmpty.visibility = View.VISIBLE
                nestedScrollView.visibility = View.GONE
            } else {
                emptyState.layoutEmpty.visibility = View.GONE
                nestedScrollView.visibility = View.VISIBLE
            }
        }
    }

    override fun printLog(msg: String) {
        Log.d("PopularUserFragment", msg)
    }
}