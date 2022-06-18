package com.example.calarity.database.dinner

import androidx.lifecycle.LiveData


//abstracts access to multiple data sources

class DinnerRepository(private val dinnerDAO: DinnerDAO) {

    val readAllData: LiveData<List<Dinner>> = dinnerDAO.readAllData()

    suspend fun addDinner(dinner: Dinner){
        dinnerDAO.addDinner(dinner)
    }

    suspend fun updateDinner(dinner: Dinner){
        dinnerDAO.updateDinner(dinner)
    }

    suspend fun deleteDinner(dinner: Dinner){
        dinnerDAO.deleteDinner(dinner)
    }

    suspend fun deleteAllDinners(){
        dinnerDAO.deleteAllDinners()
    }
}