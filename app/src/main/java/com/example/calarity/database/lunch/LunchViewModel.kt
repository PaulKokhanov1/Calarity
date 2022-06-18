package com.example.calarity.database.lunch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.calarity.database.MealDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LunchViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Lunch>>
    private val repository: LunchRepository

    init {
        val lunchDao = MealDatabase.getDatabase(application).lunchDao()
        repository = LunchRepository(lunchDao)
        readAllData = repository.readAllData
    }

    fun addLunch(lunch: Lunch){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLunch(lunch)
        }
    }

    fun updateLunch(lunch: Lunch){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLunch(lunch)
        }
    }

    fun deleteLunch(lunch: Lunch){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteLunch(lunch)
        }
    }

    fun deleteAllLunches(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllLunches()
        }
    }
}