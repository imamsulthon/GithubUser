package com.mamsky.accenture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamsky.accenture.base.BaseResult
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
    private val _liveData = MutableLiveData<List<UserViewParam>>()
    private var _liveDataFavorites = MutableLiveData<List<UserViewParam>>()

    // getter value
    fun getUsers(): LiveData<List<UserViewParam>> = _liveData
    fun getFavorites(): LiveData<List<UserViewParam>> = _liveDataFavorites

    fun fetchList() {
        viewModelScope.launch {
            when (val result = repository.getUsers()) {
                is BaseResult.Success -> _liveData.postValue(result.data)
                else -> {
                    // todo
                }
            }
        }
    }

    fun fetchFavorites(sorted: Boolean = false) {
        viewModelScope.launch {
            val favorites = repository.getFavorites()
            if (sorted) favorites.sortedBy { it.id }
            _liveDataFavorites.postValue(favorites)
        }
    }

}