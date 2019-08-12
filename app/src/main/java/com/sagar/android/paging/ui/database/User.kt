package com.sagar.android.paging.ui.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    val name: String,
    val phone: String,
    val email: String
)