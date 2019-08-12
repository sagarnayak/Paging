package com.sagar.android.paging.ui.database

import androidx.paging.PageKeyedDataSource

class UserDataSource (
    dao: Dao
):PageKeyedDataSource<Int,User>(){

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }
}