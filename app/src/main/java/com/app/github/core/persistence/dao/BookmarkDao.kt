package com.app.github.core.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.github.core.persistence.entity.BookmarkEntity

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM Bookmark")
    fun getAllBookmark(): LiveData<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun delete(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM Bookmark WHERE id = :id")
    fun getBookmarkById(id: Int): LiveData<BookmarkEntity>
}
