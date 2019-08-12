package com.sagar.android.paging.ui.database

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.sagar.android.paging.R
import kotlinx.android.synthetic.main.activity_data_base.*

class DataBaseActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "paging_tag"
    }

    private lateinit var dataBase: DataBase
    private lateinit var dao: Dao
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        setSupportActionBar(toolbar)

        dataBase = Room.databaseBuilder(
            this,
            DataBase::class.java,
            "userDataBase.db"
        ).build()

        dao = dataBase.userDao()

        handler = Handler()

        getAllData()

        Thread {
            dao.insert(
                User(
                    id = 0,
                    name = "sagar nayak",
                    phone = "123123432423",
                    email = "sagar@gmail.com"
                )
            )
        }.start()

      /*  Thread {
            Thread.sleep(4000)
            dao.deleteAll()
        }.start()*/
    }

    private fun getAllData() {
        handler.postDelayed(
            {
                dao.getAllData().observe(
                    this,
                    Observer<List<User>> { t ->
                        Log.i(TAG, "got data")
                        for (user in t) {
                            Log.i(TAG, user.toString())
                        }
                    }
                )
            },100
        )
    }

}
