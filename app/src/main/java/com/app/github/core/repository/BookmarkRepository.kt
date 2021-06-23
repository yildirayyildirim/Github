package com.app.github.core.repository

import androidx.lifecycle.LiveData
import com.app.github.core.persistence.dao.BookmarkDao
import com.app.github.core.persistence.entity.BookmarkEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookmarkRepository
@Inject
constructor(private val bookmarkDao: BookmarkDao) {

    fun getAllBookmark(): LiveData<List<BookmarkEntity>> {
        return bookmarkDao.getAllBookmark();
    }
}