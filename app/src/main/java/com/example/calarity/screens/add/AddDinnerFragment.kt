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
import com.example.calarity.database.dinner.Dinner
import com.example.calarity.database.dinner.DinnerViewModel
import com.example.calarity.databinding.FragmentAddDinnerBinding

class AddDinnerFragment : Fragment() {

    private lateinit var dinnerViewModel: DinnerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAddDinnerBinding>(inflater,
            R.layout.fragment_add_dinner, container, false)

        dinnerViewModel = ViewModelProvider(this).get(DinnerViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase(binding)
        }

        return binding.root
    }

    private fun insertDataToDatabase(binding: FragmentAddDinnerBinding){

        val dinnerName = binding.addMealNameEt.text.toString()
        val calories = binding.addCaloriesEt.text
        val protein = binding.addProteinEt.text
        val carbs = binding.addCarbsEt.text
        val fats =  binding.addFatsEt.text

        if (inputCheck(dinnerName, calories, protein, carbs, fats)){
            //Create Dinner Object

            val dinner = Dinner(0, dinnerName, calories.toString().toDouble(), protein.toString().toDouble(), carbs.toString().toDouble(), fats.toString().toDouble())

            //Add Data to Database
            dinnerViewModel.addDinner(dinner)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addDinnerFragment_to_diaryFragment)
        } else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(dinnerName: String, calories: Editable, protein: Editable, carbs: Editable, fats: Editable): Boolean{
        return !(TextUtils.isEmpty(dinnerName) || calories.isEmpty() || protein.isEmpty()
                || carbs.isEmpty() || fats.isEmpty())

    }

}