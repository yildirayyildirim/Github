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

    val getAllBookmark: LiveData<List<BookmarkEntity>> = bookmarkDao.getAllBookmark()

    fun getBookmarkEntityById(id: Int): LiveData<BookmarkEntity> {
        return bookmarkDao.getBookmarkById(id)
    }

    suspend fun insert(bookmarkEntity: BookmarkEntity) {
        bookmarkDao.insert(bookmarkEntity)
    }

    suspend fun delete(bookmarkEntity: BookmarkEntity) {
        bookmarkDao.delete(bookmarkEntity)
    }

}