package com.example.calarity.screens.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calarity.R
import com.example.calarity.database.breakfast.Breakfast
import com.example.calarity.database.breakfast.BreakfastViewModel
import com.example.calarity.databinding.FragmentAddBreakfastBinding

class AddBreakfastFragment : Fragment() {

    private lateinit var breakfastViewModel: BreakfastViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAddBreakfastBinding>(inflater,
            R.layout.fragment_add_breakfast, container, false)

        breakfastViewModel = ViewModelProvider(this).get(BreakfastViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase(binding)
        }

        return binding.root
    }

    private fun insertDataToDatabase(binding: FragmentAddBreakfastBinding){

        val breakfastName = binding.addMealNameEt.text.toString()
        val calories = binding.addCaloriesEt.text
        val protein = binding.addProteinEt.text
        val carbs = binding.addCarbsEt.text
        val fats =  binding.addFatsEt.text

        if (inputCheck(breakfastName, calories, protein, carbs, fats)){
            //Create Breakfast Object

            val breakfast = Breakfast(0, breakfastName, calories.toString().toDouble(), protein.toString().toDouble(), carbs.toString().toDouble(), fats.toString().toDouble())

            //Add Data to Database
            breakfastViewModel.addBreakfast(breakfast)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addBreakfastFragment_to_diaryFragment)
        } else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }

    }


    private fun inputCheck(breakfastName: String, calories: Editable, protein: Editable, carbs: Editable, fats: Editable): Boolean{
        return !(TextUtils.isEmpty(breakfastName) || calories.isEmpty() || protein.isEmpty()
                || carbs.isEmpty() || fats.isEmpty())

    }

}