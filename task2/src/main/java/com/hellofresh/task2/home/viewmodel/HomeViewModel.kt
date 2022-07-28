package com.hellofresh.task2.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellofresh.task2.home.model.HomeRepository
import com.hellofresh.task2.home.model.RecipeModel

class HomeViewModal(application: Application): AndroidViewModel(application) {
    private var homeRepository: HomeRepository = HomeRepository()
    var receipeModelListLiveDate: LiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchAllRecipes() {
        receipeModelListLiveDate = homeRepository.fetchAllRecipes()
    }
}