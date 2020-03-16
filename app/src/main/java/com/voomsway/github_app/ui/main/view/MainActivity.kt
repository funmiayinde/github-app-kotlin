package com.voomsway.github_app.ui.main.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.voomsway.github_app.R
import com.voomsway.github_app.data.api.ApiHelper
import com.voomsway.github_app.data.api.ApiServiceImpl
import com.voomsway.github_app.data.model.GithubUser
import com.voomsway.github_app.ui.base.ViewModelFactory
import com.voomsway.github_app.ui.main.adapter.MainAdapter
import com.voomsway.github_app.ui.main.viewmodel.MainViewModel
import com.voomsway.github_app.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainVewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        setUpUI()
        setUpViewModel()
        setUpAPICall()
    }

    private fun setUpUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter;
    }

    private fun setUpAPICall() {
        mainVewModel.getGithubUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE;
                    it.data?.let { users -> showList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE;
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        mainVewModel.fetchGithubUsers();
    }

    private fun showList(users: List<GithubUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged();
    }

    private fun setUpViewModel() {
        mainVewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }
}