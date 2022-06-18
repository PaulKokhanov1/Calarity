package com.example.calarity.database.breakfast

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BreakfastDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBreakfast(breakfast: Breakfast)

    @Update
    suspend fun updateBreakfast(breakfast: Breakfast)

    @Delete
    suspend fun deleteBreakfast(breakfast: Breakfast)

    @Query("DELETE FROM breakfast_table")
    suspend fun deleteAllBreakfasts()

    @Query("SELECT * FROM breakfast_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Breakfast>>
}