package com.example.calarity.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.calarity.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //apparently there is a bug where this api will trigger the splash screen on any activity changes
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContentView(R.layout.activity_main)


        //Implementation in order to use bottom Navigation Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.myNavHostFragment)
        bottomNavigationView.setupWithNavController(navController)

        /**
         * List of fragment that should not include the actionBar (i.e no back button in top left)
         */
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.diaryFragment,
                R.id.reportsFragment,
                R.id.socialFragment,
                R.id.foodsFragment
            )
            .build()

        //change this so this only shows when u navigate to the add fragment
        setupActionBarWithNavController(findNavController(R.id.myNavHostFragment), appBarConfiguration)
    }

    //this is only responsible for making the back button work, it will be displayed regardless
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.myNavHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}