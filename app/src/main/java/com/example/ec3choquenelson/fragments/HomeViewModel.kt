package com.example.ec3choquenelson.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ec3choquenelson.data.repository.MealRepository
import com.example.ec3choquenelson.model.Meal
import com.example.ec3choquenelson.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val meals: MutableLiveData<List<Meal>> = MutableLiveData<List<Meal>>()
    val meal: MutableLiveData<List<Meal>> = MutableLiveData<List<Meal>>()

    val repository = MealRepository()
    fun getMeals(){

        val allProduct = getData()

        meals.value = allProduct
    }

    fun getMealService(){

        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getMeals()
            meals.postValue(response)
        }
    }

    fun getMealServiceUnique(){

        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getMeal()
            meal.postValue(response)
        }
    }
}