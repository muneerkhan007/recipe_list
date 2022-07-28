package com.hellofresh.task2.home.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellofresh.task2.R
import com.hellofresh.task2.home.model.RecipeModel
import com.hellofresh.task2.home.viewmodel.HomeViewModal
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private val TAG = "HomeActivity"

    companion object {
        private lateinit var instance: HomeActivity
        private lateinit var mContext: Context

        fun getInstance(): HomeActivity {
            return instance
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        instance = this

        var adapter: HomeAdapter = HomeAdapter()
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter

        var homeViewModel: HomeViewModal = ViewModelProvider(this)[HomeViewModal::class.java]
        homeViewModel.fetchAllRecipes()

        homeViewModel!!.receipeModelListLiveDate.observe(this, Observer {
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<RecipeModel>)
            }else{
                showToast("Something went wrong")
            }
            progress_home.visibility = View.GONE
        })
    }

    private fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}