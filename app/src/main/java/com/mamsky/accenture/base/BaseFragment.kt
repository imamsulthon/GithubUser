package com.mamsky.accenture.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<out T: ViewDataBinding>: Fragment() {

    private lateinit var viewBinder: T

    var baseActivity: BaseActivity<*>? = null
        private set

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinder = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return viewBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
        setContent()
        setListener()
    }

    protected fun getViewBinder() = viewBinder

    protected open fun setContent() {}

    protected open fun setListener() {}

    protected open fun subscribeToLiveData() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            val activity = context as BaseActivity<*>?
            this.baseActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    open fun printLog(msg: String) {
        Log.d(javaClass.simpleName, msg)
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}