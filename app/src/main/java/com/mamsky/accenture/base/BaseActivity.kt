package com.mamsky.accenture.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<out T: ViewDataBinding>: AppCompatActivity(), BaseFragment.Callback {

    private lateinit var viewBinder: T

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewBinding()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent()
        setListener()
        subscribeToLiveData()
    }

    private fun performViewBinding() {
        viewBinder = DataBindingUtil.setContentView(this, getLayoutId())
        viewBinder.executePendingBindings()
    }

    fun getViewBinder() = viewBinder

    protected open fun setContent() {}

    protected open fun setListener() {}

    protected open fun subscribeToLiveData() {}

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

    open fun printLog(msg: String) {
        Log.d(javaClass.simpleName, msg)
    }

}