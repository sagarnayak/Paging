package com.sagar.android.paging.ui.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.sagar.android.paging.R
import com.sagar.android.paging.databinding.ActivityMainBinding
import com.sagar.android.paging.model.News
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by org.kodein.di.android.kodein()

    private val viewModelProvider: MainActivityViewModelProvider by instance()
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

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
    }

    private fun bindToViewModel() {
        viewModel.newsPagedList.observe(
            this,
            object : Observer<PagedList<News>> {
                override fun onChanged(t: PagedList<News>?) {

                }
            }
        )
    }
}
