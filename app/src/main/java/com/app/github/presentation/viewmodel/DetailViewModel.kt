package com.app.github.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.github.core.base.BaseViewModel
import com.app.github.core.persistence.entity.BookmarkEntity
import com.app.github.core.repository.BookmarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(private val repository: BookmarkRepository) : BaseViewModel() {
    var bookmarkEntity: LiveData<BookmarkEntity>

    init {
        bookmarkEntity = repository.getBookmarkEntityById(0)
    }

    fun load(id: Int) {
        getIsLoading().value = true
        bookmarkEntity = repository.getBookmarkEntityById(id)
        getIsLoading().value = false
    }

    private fun insert(bookmarkEntity: BookmarkEntity) = viewModelScope.launch {
        getIsLoading().value = true
        repository.insert(bookmarkEntity)
        getIsLoading().value = false
    }

    private fun remove(bookmarkEntity: BookmarkEntity) = viewModelScope.launch {
        getIsLoading().value = true
        repository.delete(bookmarkEntity)
        getIsLoading().value = false
    }

    fun insertAndRemove(isFavorite: Boolean, bookmarkEntity: BookmarkEntity) {
        if (isFavorite) {
            remove(bookmarkEntity)
        } else {
            insert(bookmarkEntity)
        }
        load(bookmarkEntity.id)
    }
}