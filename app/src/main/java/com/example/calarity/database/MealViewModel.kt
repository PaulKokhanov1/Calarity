package com.example.calarity.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Meal>>
    private val repository: MealRepository

    init {

        val mealDao = MealDatabase.getDatabase(application).mealDao()
        repository = MealRepository(mealDao)
        readAllData = repository.readAllData
    }

    fun addMeal(meal: Meal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMeal(meal)
        }
    }

    fun updateMeal(meal: Meal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMeal(meal)
        }
    }

    fun deleteMeal(meal: Meal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMeal(meal)
        }
    }

    fun deleteAllMeals(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllMeals()
        }
    }
}