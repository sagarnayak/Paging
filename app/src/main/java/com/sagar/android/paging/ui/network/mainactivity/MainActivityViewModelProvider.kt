package com.sagar.android.paging.ui.network.mainactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sagar.android.logutilmaster.LogUtil
import com.sagar.android.paging.repository.Repository

class MainActivityViewModelProvider(
    private val repository: Repository,
    private val logUtil: LogUtil
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainActivityViewModel(repository, logUtil) as T
    }
}