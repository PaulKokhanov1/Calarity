package com.example.calarity.database.dinner

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DinnerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDinner(dinner: Dinner)

    @Update
    suspend fun updateDinner(dinner: Dinner)

    @Delete
    suspend fun deleteDinner(dinner: Dinner)

    @Query("DELETE FROM dinner_table")
    suspend fun deleteAllDinners()

    @Query("SELECT * FROM dinner_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Dinner>>
}