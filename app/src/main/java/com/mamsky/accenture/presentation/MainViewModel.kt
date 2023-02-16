package com.mamsky.accenture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private var _liveDataFavorites = MutableLiveData<List<UserViewParam>>()
    private val _userDetail = MutableLiveData<UserDetailViewParam>()

    // getter value
    fun onLoading(): LiveData<Boolean> = _loading
    fun onError(): LiveData<Boolean> = _error
    fun getUsers(): LiveData<List<UserViewParam>> = _liveData
    fun getFavorites(): LiveData<List<UserViewParam>> = _liveDataFavorites
    fun getUserDetail(): LiveData<UserDetailViewParam> = _userDetail

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

    fun fetchDetail(username: String) {
        viewModelScope.launch {
            val result = repository.getUserDetails(username)
            _userDetail.postValue(result)
        }
    }

    fun fetchFavorites(sorted: Boolean = false) {
        viewModelScope.launch {
            val favorites = repository.getFavorites()
            if (sorted) favorites.sortedBy { it.login }
            _liveDataFavorites.postValue(favorites)
        }
    }

    fun saveAsFavorite(username: String) {

    }

    fun saveAsUnFavorite(username: String) {

    }

}