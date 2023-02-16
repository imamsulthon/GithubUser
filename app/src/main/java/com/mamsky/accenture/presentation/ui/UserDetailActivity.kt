package com.mamsky.accenture.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.mamsky.accenture.R
import com.mamsky.accenture.base.BaseActivity
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.databinding.ActivityUserDetailBinding
import com.mamsky.accenture.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : BaseActivity<ActivityUserDetailBinding>() {

    private val viewModel: MainViewModel by viewModels()

    companion object {
        const val TAG_DATA = "login"
        private var username: String = ""
        private var isFavorite: Boolean = false
    }

    override fun getLayoutId(): Int = R.layout.activity_user_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getStringExtra(TAG_DATA)?.let {
            printLog("extras $it")
            username = it
            viewModel.fetchDetail(it)
        }
    }

    override fun subscribeToLiveData() {
        super.subscribeToLiveData()
        viewModel.getUserDetail().observe(this) {
            it?.let {
                printLog("getUserDetail $it")
                setContent(it)
            }
        }
    }

    override fun setContent() {
        super.setContent()
        with(getViewBinder()){
            toolbarStart.setOnClickListener { onBackPressed() }
            toolbarTitle.text = "@$username"
            toolbarEnd.setImageResource(
                if (isFavorite) R.drawable.ic_favorite
                else R.drawable.ic_unfavorite
            )
            toolbarEnd.setOnClickListener {
                onClickFavorite()
            }
        }
    }

    private fun setContent(item: UserDetailViewParam) {
        with(getViewBinder()) {
            Glide.with(this@UserDetailActivity)
                .load(item.avatarUrl)
                .into(ivUser)
            tvUsername.text = item.name
            tvBio.text = item.bio
            toolbarTitle.text = "@${item.login}"
            tvFollowers.text = item.followers.toString()
            tvFollowing.text = item.following.toString()
            tvFullResponse.text = item.createDetails()
        }
    }

    private fun onClickFavorite() {
        if (isFavorite) {
            getViewBinder().toolbarEnd.setImageResource(R.drawable.ic_unfavorite)
            viewModel.saveAsFavorite(username)
        } else {
            getViewBinder().toolbarEnd.setImageResource(R.drawable.ic_favorite)
            viewModel.saveAsUnFavorite(username)
        }
        isFavorite = !isFavorite
    }

    private fun UserDetailViewParam.createDetails(): String = "Other Info: \n" +
            "id: $id" + "\n" +
            "type: $type" + "\n" +
            "company: $company" + "\n" +
            "blog: $blog" + "\n" +
            "location: $location" + "\n" +
            "organizationUrl: $organizationsUrl" + "\n" +
            "repos: $reposUrl" + "\n" +
            "twitter: $twitterUsername"
}