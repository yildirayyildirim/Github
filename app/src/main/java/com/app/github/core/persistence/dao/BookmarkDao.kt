package com.app.github.core.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.github.core.persistence.entity.BookmarkEntity

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM Bookmark")
    fun getAllBookmark(): LiveData<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: BookmarkEntity)

    @Query("SELECT * FROM Bookmark WHERE id = :id")
    fun getBookmarkById(id: Int): LiveData<BookmarkEntity>
}
