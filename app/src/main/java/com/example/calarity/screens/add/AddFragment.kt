package com.example.calarity.screens.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calarity.R
import com.example.calarity.database.Meal
import com.example.calarity.database.MealViewModel
import com.example.calarity.databinding.FragmentAddBinding
import com.example.calarity.databinding.FragmentDiaryBinding


class AddFragment : Fragment() {

    private lateinit var mealViewModel: MealViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAddBinding>(inflater,
            R.layout.fragment_add, container, false)

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase(binding)
        }

        return binding.root
    }

    private fun insertDataToDatabase(binding: FragmentAddBinding){

        val mealName = binding.addMealNameEt.text.toString()
        val calories = binding.addCaloriesEt.text.toString()
        val protein = binding.addProteinEt.text.toString()
        val carbs = binding.addCarbsEt.text.toString()
        val fats =  binding.addFatsEt.text.toString()

        if (inputCheck(mealName, calories, protein, carbs, fats)){
            //Create Meal Object

            val meal = Meal(0, mealName, calories.toDouble(), protein.toDouble(), carbs.toDouble(), fats.toDouble())

            //Add Data to Database
            mealViewModel.addMeal(meal)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_diaryFragment)
        } else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }




    }

    private fun inputCheck(mealName: String, calories: String, protein: String, carbs: String, fats: String): Boolean{
        return !(TextUtils.isEmpty(mealName) && TextUtils.isEmpty(calories) && TextUtils.isEmpty(protein)
                && TextUtils.isEmpty(carbs) && TextUtils.isEmpty(fats))
    }

}