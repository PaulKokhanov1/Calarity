package com.example.calarity.database.lunch

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LunchDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLunch(lunch: Lunch)

    @Update
    suspend fun updateLunch(lunch: Lunch)

    @Delete
    suspend fun deleteLunch(lunch: Lunch)

    @Query("DELETE FROM lunch_table")
    suspend fun deleteAllLunches()

    @Query("SELECT * FROM lunch_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Lunch>>
}