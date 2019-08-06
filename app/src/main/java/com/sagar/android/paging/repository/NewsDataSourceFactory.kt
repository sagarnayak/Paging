package com.sagar.android.paging.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.sagar.android.logutilmaster.LogUtil
import com.sagar.android.paging.model.News

class NewsDataSourceFactory(
    private val repository: Repository,
    private val logUtil: LogUtil
) : DataSource.Factory<Int, News>() {

  public  val mutableLiveData = MutableLiveData<PageKeyedDataSource<Int, News>>()

    override fun create(): DataSource<Int, News> {
        val dataSource = NewsDataSource(repository, logUtil)
        mutableLiveData.postValue(dataSource)
        return dataSource
    }
}
