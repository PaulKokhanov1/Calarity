package com.example.calarity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calarity.database.breakfast.Breakfast
import com.example.calarity.database.breakfast.BreakfastDAO
import com.example.calarity.database.dinner.Dinner
import com.example.calarity.database.dinner.DinnerDAO
import com.example.calarity.database.lunch.Lunch
import com.example.calarity.database.lunch.LunchDAO

//Database Holder

@Database(entities = [Meal::class, Breakfast::class, Lunch::class, Dinner::class], version = 3, exportSchema = false)
abstract class MealDatabase: RoomDatabase() {

    //returns our different DAO's
    abstract fun mealDao(): MealDao
    abstract fun breakfastDao(): BreakfastDAO
    abstract fun lunchDao(): LunchDAO
    abstract fun dinnerDao(): DinnerDAO

    //visible to other classes
    companion object {

        //Voltaile means writes to this field are made visible to other threads
        @Volatile
        private var INSTANCE: MealDatabase? = null

        fun getDatabase(context: Context): MealDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            //synchronized prevents multiple threads from concurrently using this block
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MealDatabase::class.java,
                    "meal_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}