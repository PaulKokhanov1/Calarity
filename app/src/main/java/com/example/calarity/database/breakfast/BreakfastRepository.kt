package com.example.calarity.database.breakfast

import androidx.lifecycle.LiveData

//abstracts access to multiple data sources

class BreakfastRepository(private val breakfastDAO: BreakfastDAO) {

    val readAllData: LiveData<List<Breakfast>> = breakfastDAO.readAllData()

    suspend fun addBreakfast(breakfast: Breakfast){
        breakfastDAO.addBreakfast(breakfast)
    }

    suspend fun updateBreakfast(breakfast: Breakfast){
        breakfastDAO.updateBreakfast(breakfast)
    }

    suspend fun deleteBreakfast(breakfast: Breakfast){
        breakfastDAO.deleteBreakfast(breakfast)
    }

    suspend fun deleteAllBreakfasts(){
        breakfastDAO.deleteAllBreakfasts()
    }
}