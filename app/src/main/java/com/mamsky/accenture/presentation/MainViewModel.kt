package com.mamsky.accenture.presentation

import android.util.Log
import androidx.lifecycle.*
import com.mamsky.accenture.base.BaseResult
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository,
): ViewModel() {

    // setter value
    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<Boolean>()
    private val _liveData = MutableLiveData<List<UserViewParam>>()
    private val _userDetail = MutableLiveData<UserDetailViewParam>()
    private val _isFavorite = MutableLiveData<Boolean>()

    // getter value
    fun onLoading(): LiveData<Boolean> = _loading
    fun onError(): LiveData<Boolean> = _error
    fun getUsers(): LiveData<List<UserViewParam>> = _liveData
    fun getFavorites(): LiveData<List<UserViewParam>> = repository.getFavorites().asLiveData()
    fun getUserDetail(): LiveData<UserDetailViewParam> = _userDetail
    fun isFavorite() = _isFavorite

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

    private var tempData: UserDetailViewParam? = null

    fun fetchDetail(username: String) {
        viewModelScope.launch {
            val result = repository.getUserDetails(username)
            tempData = result
            _userDetail.postValue(result)
        }
    }

    fun saveAsFavorite(username: String) {
        viewModelScope.launch {
            tempData?.let {
                if (username == it.login)
                    try {
                        repository.saveUserAsFavorite(it)
                        printLog("saveAsFavorite $username")
                        _isFavorite.postValue(true)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
            }
        }
    }

    fun removeAsFavorite(username: String) {
        viewModelScope.launch {
            tempData?.let {
                if (username == it.login)
                    try {
                        repository.clearUserAsFavorite(it)
                        printLog("setAsUnFavorite $username")
                        _isFavorite.postValue(false)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
            }
        }
    }

    fun checkFavorite(username: String) {
        viewModelScope.launch {
            val f = repository.isFavorite(username)
            printLog("setAsUnFavorite $username $f")
            _isFavorite.postValue(f)
        }
    }

    private fun printLog(msg: String) {
        Log.d("MainViewModel", msg)
    }

}