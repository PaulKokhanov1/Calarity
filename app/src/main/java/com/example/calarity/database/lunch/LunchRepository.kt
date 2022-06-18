package com.example.calarity.database.lunch

import androidx.lifecycle.LiveData


//abstracts access to multiple data sources

class LunchRepository(private val lunchDAO: LunchDAO) {

    val readAllData: LiveData<List<Lunch>> = lunchDAO.readAllData()

    suspend fun addLunch(lunch: Lunch){
        lunchDAO.addLunch(lunch)
    }

    suspend fun updateLunch(lunch: Lunch){
        lunchDAO.updateLunch(lunch)
    }

    suspend fun deleteLunch(lunch: Lunch){
        lunchDAO.deleteLunch(lunch)
    }

    suspend fun deleteAllLunches(){
        lunchDAO.deleteAllLunches()
    }
}