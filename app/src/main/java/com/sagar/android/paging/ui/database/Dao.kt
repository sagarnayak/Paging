package com.sagar.android.paging.ui.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {

    @Insert
    fun insert(user: User)

    @Update
    fun updateUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAll()

    @Query("SELECT * FROM user_table")
    fun getAllData(): LiveData<List<User>>
}