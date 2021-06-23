package com.app.github.core.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.github.core.persistence.dao.BookmarkDao
import com.app.github.core.persistence.entity.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 3,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): BookmarkDao
}