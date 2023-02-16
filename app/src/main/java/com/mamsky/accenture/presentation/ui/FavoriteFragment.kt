package com.mamsky.accenture.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamsky.accenture.R
import com.mamsky.accenture.base.BaseFragment
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.databinding.FragmentUserListBinding
import com.mamsky.accenture.presentation.MainViewModel
import com.mamsky.accenture.presentation.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment: BaseFragment<FragmentUserListBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_user_list

    override fun onStart() {
        super.onStart()
        viewModel.getFavorites()
    }

    override fun setContent() {
        super.setContent()
        with(getViewBinder()) {
            fabFilter.visibility = View.VISIBLE
        }
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()
        viewModel.getFavorites().observe(viewLifecycleOwner) { list ->
            list?.let {
                it.forEach { x -> printLog("data $x") }
                setRecyclerView(it)
            }
        }
    }

    private fun setRecyclerView(list: List<UserViewParam>) {
        with(getViewBinder()) {
            recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerview.adapter = UserListAdapter(list) {
                printLog("onclick $it")
                startActivity(Intent(requireContext(), UserDetailActivity::class.java).apply {
                    putExtra(UserDetailActivity.TAG_DATA, it)
                })
            }
        }
    }

    override fun printLog(msg: String) {
        Log.d("FavoriteFragment", msg)
    }

}