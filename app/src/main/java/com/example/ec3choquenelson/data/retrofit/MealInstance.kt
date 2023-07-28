package com.example.ec3choquenelson.data.retrofit

import com.example.ec3choquenelson.data.response.MealListResponse
import com.example.ec3choquenelson.data.response.MealResponse
import retrofit2.http.GET

interface MealInstance {

    @GET("filter.php?c=Seafood")
    suspend fun getAllMeans(): MealListResponse

    @GET("search.php?s=Arrabiata")
    suspend fun getMeal(): MealResponse
}