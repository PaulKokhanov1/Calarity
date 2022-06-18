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
import com.example.calarity.database.lunch.Lunch
import com.example.calarity.database.lunch.LunchViewModel
import com.example.calarity.databinding.FragmentAddLunchBinding

class AddLunchFragment : Fragment() {

    private lateinit var lunchViewModel: LunchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAddLunchBinding>(inflater,
            R.layout.fragment_add_lunch, container, false)

        lunchViewModel = ViewModelProvider(this).get(LunchViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase(binding)
        }

        return binding.root
    }

    private fun insertDataToDatabase(binding: FragmentAddLunchBinding){

        val lunchName = binding.addMealNameEt.text.toString()
        val calories = binding.addCaloriesEt.text
        val protein = binding.addProteinEt.text
        val carbs = binding.addCarbsEt.text
        val fats =  binding.addFatsEt.text

        if (inputCheck(lunchName, calories, protein, carbs, fats)){
            //Create Breakfast Object

            val lunch = Lunch(0, lunchName, calories.toString().toDouble(), protein.toString().toDouble(), carbs.toString().toDouble(), fats.toString().toDouble())

            //Add Data to Database
            lunchViewModel.addLunch(lunch)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addLunchFragment_to_diaryFragment)
        } else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }

    }


    private fun inputCheck(lunchName: String, calories: Editable, protein: Editable, carbs: Editable, fats: Editable): Boolean{
        return !(TextUtils.isEmpty(lunchName) || calories.isEmpty() || protein.isEmpty()
                || carbs.isEmpty() || fats.isEmpty())

    }

}