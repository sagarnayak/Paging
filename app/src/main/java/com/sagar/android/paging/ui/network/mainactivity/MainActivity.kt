package com.sagar.android.paging.ui.network.mainactivity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.sagar.android.logutilmaster.LogUtil
import com.sagar.android.paging.R
import com.sagar.android.paging.databinding.ActivityMainBinding
import com.sagar.android.paging.model.News
import com.sagar.android.paging.ui.network.mainactivity.adapter.NewsAdapter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by org.kodein.di.android.kodein()

    private val viewModelProvider: MainActivityViewModelProvider by instance()
    private val logUtil: LogUtil by instance()
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        viewModel = ViewModelProviders.of(this, viewModelProvider)
            .get(MainActivityViewModel::class.java)

        setUpList()

        bindToViewModel()
    }

    private fun setUpList() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun bindToViewModel() {
        viewModel.newsPagedList.observe(
            this,
            Observer<PagedList<News>> { t -> adapter.submitList(t) }
        )

        viewModel.newsPagedListDataSource.observe(
            this,
            Observer<PageKeyedDataSource<Int, News>> { t ->
                logUtil.logV("new data source generated")
                Handler().postDelayed(
                    {
                        logUtil.logV("invalidating ...")
                        t?.invalidate()
                    },
                    20000
                )
            }
        )
    }
}
