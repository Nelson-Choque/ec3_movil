package com.example.ec3choquenelson.model

import com.google.gson.annotations.SerializedName

data class Meal(

    @SerializedName("idMeal")
    val idMeal: Int,

    @SerializedName("strMeal")
    val name:String,

    @SerializedName("strMealThumb")
    val imgUrl: String = "",

    @SerializedName("strArea")
    val category: String = "",

    @SerializedName("Region")
    val Region: String = "",

    @SerializedName("strInstructions")
    val instrucciones: String = ""


)


fun getData(): List<Meal> = listOf(
    Meal(3,"timy"),
    Meal(1,"nelson"),

)
