package com.app.github.core.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bookmark")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "ID") var id: Int,
    @ColumnInfo(name = "AVATAR_URL") var avatarUrl: String?,
    @ColumnInfo(name = "NAME") var name: String?,
    @ColumnInfo(name = "DESCRIPTION") var description: String?,
    @ColumnInfo(name = "STARGAZERS_COUNT") var stargazersCount: Int = 0,
    @ColumnInfo(name = "LOGIN") var login: String?,
    @ColumnInfo(name = "ISSUESSTRING") var issues: String?,

    )