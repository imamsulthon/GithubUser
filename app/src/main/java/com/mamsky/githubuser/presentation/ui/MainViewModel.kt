package com.mamsky.githubuser.presentation.ui

import android.util.Log
import androidx.lifecycle.*
import com.mamsky.core.base.BaseResult
import com.mamsky.data.user.model.UserViewParam
import com.mamsky.data.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(
    private val repository: UserRepository,
): ViewModel() {

    // setter value
    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<Boolean>()
    private val _liveData = MutableLiveData<List<UserViewParam>>()

    // getter value
    fun onLoading(): LiveData<Boolean> = _loading
    fun onError(): LiveData<Boolean> = _error
    fun getUsers(): LiveData<List<UserViewParam>> = _liveData

    fun fetchList() {
        _loading.postValue(true)
        viewModelScope.launch {
            when (val result = repository.getUsers()) {
                is BaseResult.Success -> {
                    _loading.postValue(false)
                    _liveData.postValue(result.data)
                }
                else -> {
                    _loading.postValue(false)
                    _error.postValue(true)
                }
            }
        }
    }

    open fun search(userName: String) {

        viewModelScope.launch {
            when (val result = repository.searchUsers(userName)) {
                is BaseResult.Success -> {
                    _loading.postValue(false)
                    _liveData.postValue(result.data)
                }
                else -> {
                    _loading.postValue(false)
                    _error.postValue(true)
                }
            }
        }
    }

    private fun printLog(msg: String) {
        Log.d("MainViewModel", msg)
    }

}