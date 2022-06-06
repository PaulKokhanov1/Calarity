package com.example.calarity.database

import androidx.lifecycle.LiveData

//abstracts access to multiple data sources

class MealRepository(private val mealDao: MealDao) {

    val readAllData: LiveData<List<Meal>> = mealDao.readAllData()

    suspend fun addMeal(meal: Meal){
        mealDao.addMeal(meal)
    }

    suspend fun updateMeal(meal: Meal){
        mealDao.updateMeal(meal)
    }

    suspend fun deleteMeal(meal: Meal){
        mealDao.deleteMeal(meal)
    }

    suspend fun deleteAllMeals(){
        mealDao.deleteAllMeals()
    }
}