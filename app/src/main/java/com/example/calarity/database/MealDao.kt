package com.example.calarity.database

import androidx.lifecycle.LiveData
import androidx.room.*

//Used for accessing Database

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeal(meal: Meal)

    @Update
    suspend fun updateMeal(meal: Meal)

    @Delete
    suspend fun deleteMeal(meal: Meal)

    @Query("DELETE FROM meal_table")
    suspend fun deleteAllMeals()


    @Query("SELECT * FROM meal_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Meal>>
}