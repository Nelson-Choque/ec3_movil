package com.example.ec3choquenelson.data.repository

import com.example.ec3choquenelson.data.retrofit.RetrofitHelper
import com.example.ec3choquenelson.model.Meal

class MealRepository {

    suspend fun getMeals(): List<Meal>{

        val response = RetrofitHelper.mealInstance.getAllMeans()
        return response.meals
    }

    suspend fun getMeal(): List<Meal>{

        val response = RetrofitHelper.mealInstance.getMeal()
        return response.meal
    }
}