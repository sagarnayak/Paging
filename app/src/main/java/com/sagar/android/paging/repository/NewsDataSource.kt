package com.sagar.android.paging.repository

import androidx.paging.PageKeyedDataSource
import com.sagar.android.logutilmaster.LogUtil
import com.sagar.android.paging.model.News

class NewsDataSource(
    private val repository: Repository,
    private val logUtil: LogUtil
) : PageKeyedDataSource<Int, News>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, News>) {
        //call the api here
        //and pass it through the callback provided
        /*callback.onResult(
            newslist,
            null,
            currentPage+1
        )*/
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        /*
        here we will get the previous page key from params.key
        and we can do the api call with the help of repository or from database.
         */
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        /*
        this is also the same like after page.
        here just net the previous page instead of the next page.

        if the next or previous page is there then assign null or else do the page number
        calculation.
         */
    }
}