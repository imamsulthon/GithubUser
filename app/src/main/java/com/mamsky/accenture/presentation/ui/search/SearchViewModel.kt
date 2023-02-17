package com.mamsky.accenture.presentation.ui.search

import com.mamsky.data.user.repository.UserRepository
import com.mamsky.accenture.presentation.ui.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: UserRepository,
): MainViewModel(repository) {


}