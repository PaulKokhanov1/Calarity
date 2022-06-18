package com.example.calarity.database.dinner

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "dinner_table")
data class Dinner (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val food_name: String,
    val Calories: Double,
    val Carbs: Double,
    val Protein: Double,
    val Fats: Double
): Parcelable
