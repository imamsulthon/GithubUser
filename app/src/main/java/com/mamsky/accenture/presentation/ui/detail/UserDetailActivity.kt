package com.mamsky.accenture.presentation.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.mamsky.accenture.R
import com.mamsky.core.base.BaseActivity
import com.mamsky.data.user.model.UserDetailViewParam
import com.mamsky.accenture.databinding.ActivityUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : BaseActivity<ActivityUserDetailBinding>() {

    private val viewModel: DetailViewModel by viewModels()

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
        viewModel.isFavorite().observe(this) {
            it?.let {
                isFavorite = it
                setFavorite(isFavorite)
            }
        }
    }

    override fun setContent() {
        super.setContent()
        with(getViewBinder()){
            toolbarStart.setOnClickListener { onBackPressed() }
            toolbarTitle.text = "@$username"
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
            viewModel.checkFavorite(username)
        }
    }

    private fun onClickFavorite() {
        printLog("onClickFavorite value $isFavorite")
        if (isFavorite) {
            viewModel.removeAsFavorite(username)
        } else {
            viewModel.saveAsFavorite(username)
        }
    }

    private fun setFavorite(isFavorite: Boolean) {
        printLog("setFavorite value $isFavorite")
        getViewBinder().toolbarEnd.setImageResource(
            if (isFavorite) R.drawable.ic_favorite
            else R.drawable.ic_unfavorite
        )
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