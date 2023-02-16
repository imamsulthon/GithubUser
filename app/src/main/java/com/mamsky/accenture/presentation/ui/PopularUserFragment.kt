package com.mamsky.accenture.presentation.ui

import android.content.Intent
import android.util.Log
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
class PopularUserFragment: BaseFragment<FragmentUserListBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_user_list

    override fun setContent() {
        super.setContent()
        viewModel.fetchList()
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()
        viewModel.getUsers().observe(viewLifecycleOwner) { list ->
            list?.let {
                printLog("data ${it.size} $it")
                setRecyclerView(it)
            }
        }

        viewModel.onError().observe(viewLifecycleOwner) {
            // todo
        }

        viewModel.onLoading().observe(viewLifecycleOwner) {
            // todo
        }
    }

    private fun setRecyclerView(list: List<UserViewParam>) {
        with(getViewBinder()) {
            recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerview.adapter = UserListAdapter(list)  {
                printLog("onclick $it")
                startActivity(Intent(requireContext(), UserDetailActivity::class.java).apply {
                    putExtra(UserDetailActivity.TAG_DATA, it)
                })
            }
        }
    }

    override fun printLog(msg: String) {
        Log.d("PopularUserFragment", msg)
    }
}