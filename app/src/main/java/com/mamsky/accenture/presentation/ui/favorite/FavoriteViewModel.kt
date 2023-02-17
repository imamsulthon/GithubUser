package com.mamsky.accenture.presentation.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.data.repository.UserRepository
import com.mamsky.accenture.presentation.ui.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: UserRepository,
): MainViewModel(repository) {

    fun getFavorites(query: String? = null): LiveData<List<UserViewParam>> =
        if (query.isNullOrEmpty()) repository.getFavorites().asLiveData()
        else repository.searchUserFromDb(query).asLiveData()

//    var searchResult: LiveData<List<UserViewParam>>? = null
//
//    override fun search(userName: String) {
//        viewModelScope.launch {
//            val result = repository.searchUserFromDb(userName).asLiveData()
//            searchResult = result
//        }
//    }
}