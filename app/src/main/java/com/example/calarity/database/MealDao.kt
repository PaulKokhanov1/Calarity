package com.example.calarity.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Used for accessing Database

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeal(meal: Meal)


    @Query("SELECT * FROM meal_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Meal>>
}