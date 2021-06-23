package com.app.github.presentation.viewmodel

import com.app.github.core.base.BaseViewModel
import com.app.github.core.repository.BookmarkRepository
import com.app.github.core.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(private val repository: BookmarkRepository) : BaseViewModel() {
}