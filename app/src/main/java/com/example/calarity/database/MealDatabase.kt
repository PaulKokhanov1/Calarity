package com.example.calarity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Database Holder

@Database(entities = [Meal::class], version = 1, exportSchema = false)
abstract class MealDatabase: RoomDatabase() {

    //returns our Meal DAO
    abstract fun mealDao(): MealDao

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
                ).build()
                INSTANCE = instance
                return instance

            }
        }
    }
}