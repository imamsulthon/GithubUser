package com.mamsky.accenture.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private var tempData: UserDetailViewParam? = null
    private val _userDetail = MutableLiveData<UserDetailViewParam>()
    private val _isFavorite = MutableLiveData<Boolean>()

    fun getUserDetail(): LiveData<UserDetailViewParam> = _userDetail
    fun isFavorite() = _isFavorite

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