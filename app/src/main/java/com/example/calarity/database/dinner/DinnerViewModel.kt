package com.example.calarity.database.dinner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.calarity.database.MealDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DinnerViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Dinner>>
    private val repository: DinnerRepository

    init {
        val dinnerDao = MealDatabase.getDatabase(application).dinnerDao()
        repository = DinnerRepository(dinnerDao)
        readAllData = repository.readAllData
    }

    fun addDinner(dinner: Dinner){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDinner(dinner)
        }
    }

    fun updateDinner(dinner: Dinner){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDinner(dinner)
        }
    }

    fun deleteDinner(dinner: Dinner){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDinner(dinner)
        }
    }

    fun deleteAllDinners(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDinners()
        }
    }
}