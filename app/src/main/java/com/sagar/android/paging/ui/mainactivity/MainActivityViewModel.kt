package com.sagar.android.paging.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.sagar.android.logutilmaster.LogUtil
import com.sagar.android.paging.model.News
import com.sagar.android.paging.repository.NewsDataSourceFactory
import com.sagar.android.paging.repository.Repository

class MainActivityViewModel(
    private val repository: Repository,
    private val logUtil: LogUtil
) : ViewModel() {

    var newsPagedList: LiveData<PagedList<News>>
    var newsPagedListDataSource: LiveData<PageKeyedDataSource<Int, News>>
    var newsDataSourceFactory: NewsDataSourceFactory = NewsDataSourceFactory(repository, logUtil)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(2)
            .setEnablePlaceholders(false)
            .build()
        newsPagedListDataSource = newsDataSourceFactory.mutableLiveData

        newsPagedList = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }
}