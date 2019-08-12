package com.sagar.android.paging.ui.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract class DataBase :RoomDatabase(){

    abstract fun userDao():Dao
}