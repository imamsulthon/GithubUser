package com.mamsky.accenture.presentation.ui.favorite

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamsky.accenture.R
import com.mamsky.core.base.BaseFragment
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.databinding.FragmentUserListBinding
import com.mamsky.accenture.presentation.adapter.UserListAdapter
import com.mamsky.accenture.presentation.ui.detail.UserDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment: BaseFragment<FragmentUserListBinding>() {

    private val viewModel: FavoriteViewModel by viewModels()
    private var job: Job? = null

    private val adapter: UserListAdapter by lazy {
        UserListAdapter(listOf()) {
            startActivity(Intent(requireContext(), UserDetailActivity::class.java).apply {
                putExtra(UserDetailActivity.TAG_DATA, it)
            })
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_user_list

    override fun onStart() {
        super.onStart()
        viewModel.getFavorites()
    }

    override fun setContent() {
        super.setContent()
        with(getViewBinder()) {
            fabFilter.visibility = View.VISIBLE
            recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerview.adapter = adapter
            swipeRefresh.isEnabled = false
        }
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()
        viewModel.getFavorites().observe(viewLifecycleOwner) { list ->
            if (list.isNullOrEmpty()) {
                showEmptyState(true)
                return@observe
            }
            list.let {
                showEmptyState(false)
                updateRecyclerView(it)
            }
        }
    }

    private fun updateRecyclerView(list: List<UserViewParam>) {
        adapter.updateData(list)
    }

    fun onSearch(query: String) {
        job?.cancel()
        job = lifecycleScope.launch {
            delay(500)
            printLog("onSearch $query")
            viewModel.getFavorites(query)
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
        Log.d("FavoriteFragment", msg)
    }

}