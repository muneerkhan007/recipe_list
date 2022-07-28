package com.hellofresh.task2.home.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellofresh.task2.network.ApiClient
import com.hellofresh.task2.network.ApiInterface
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {
    private var apiInterface: ApiInterface? = null
    private val TAG = "HomeRepository"
    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }
    fun fetchAllRecipes(): LiveData<List<RecipeModel>> {
        val data = MutableLiveData<List<RecipeModel>>()
        apiInterface?.fetchAllRecipes()?.enqueue(object : Callback<List<RecipeModel>> {
            override fun onResponse(
                call: retrofit2.Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                val res = response.body()
                if(response.code() == 200 && res != null) {
                    data.postValue(res)
                } else data.value = null;
            }

            override fun onFailure(call: retrofit2.Call<List<RecipeModel>>, t: Throwable) {
                Log.d(TAG, "onFailure: "+ t.message)
                data.value = null
            }

        })
        return data
    }
}