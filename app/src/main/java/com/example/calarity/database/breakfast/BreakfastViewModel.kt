package com.example.calarity.database.breakfast

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.calarity.database.MealDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreakfastViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Breakfast>>
    private val repository: BreakfastRepository

    init {
        val breakfastDao = MealDatabase.getDatabase(application).breakfastDao()
        repository = BreakfastRepository(breakfastDao)
        readAllData = repository.readAllData
    }

    fun addBreakfast(breakfast: Breakfast){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBreakfast(breakfast)
        }
    }

    fun updateBreakfast(breakfast: Breakfast){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBreakfast(breakfast)
        }
    }

    fun deleteBreakfast(breakfast: Breakfast){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBreakfast(breakfast)
        }
    }

    fun deleteAllBreakfasts(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllBreakfasts()
        }
    }
}