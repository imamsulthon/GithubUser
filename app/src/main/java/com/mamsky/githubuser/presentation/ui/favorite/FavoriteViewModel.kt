package com.mamsky.githubuser.presentation.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.mamsky.data.user.model.UserViewParam
import com.mamsky.data.user.repository.UserRepository
import com.mamsky.githubuser.presentation.ui.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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