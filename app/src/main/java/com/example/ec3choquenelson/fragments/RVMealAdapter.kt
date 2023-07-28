package com.example.ec3choquenelson.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ec3choquenelson.databinding.ItemMealBinding
import com.example.ec3choquenelson.model.Meal

class RVMealAdapter(var meals: List<Meal>): RecyclerView.Adapter<MealVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealVH {

        val binding = ItemMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MealVH(binding)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: MealVH, position: Int) {
        holder.bind(meals[position])
    }
}


class MealVH(private val binding : ItemMealBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(meal: Meal) {
        binding.textMeal.text = meal.name
        binding.imageMeal.load(meal.imgUrl)
    }

}