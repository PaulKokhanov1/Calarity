package com.example.calarity.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "meal_table")
data class Meal (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val food_name: String,
    val Calories: Double,
    val Carbs: Double,
    val Protein: Double,
    val Fats: Double
        ): Parcelable