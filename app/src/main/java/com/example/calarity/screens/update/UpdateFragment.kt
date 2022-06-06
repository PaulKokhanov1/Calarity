package com.example.calarity.screens.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.calarity.R
import com.example.calarity.database.Meal
import com.example.calarity.database.MealViewModel
import com.example.calarity.databinding.FragmentReportsBinding
import com.example.calarity.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    //UpdateFragmentArgs contains currentUser
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mealViewModel: MealViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentUpdateBinding>(inflater,
            R.layout.fragment_update, container, false)

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        //replaces all fields with data from item user clicked on
        binding.updateMealNameEt.setText(args.currentMeal.food_name)
        binding.updateCaloriesEt.setText(args.currentMeal.Calories.toString())
        binding.updateProteinEt.setText(args.currentMeal.Protein.toString())
        binding.updateCarbsEt.setText(args.currentMeal.Carbs.toString())
        binding.updateFatsEt.setText(args.currentMeal.Fats.toString())

        binding.updateBtn.setOnClickListener {
            updateItem(binding)
        }

        //Add menu
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateItem(binding: FragmentUpdateBinding){
        val mealName = binding.updateMealNameEt.text.toString()
        val calories = binding.updateCaloriesEt.text
        val protein = binding.updateProteinEt.text
        val carbs = binding.updateCarbsEt.text
        val fats = binding.updateFatsEt.text

        if ( inputCheck(mealName, calories, protein, carbs, fats)){
            //Create Meal Object
            val updatedMeal = Meal(args.currentMeal.id, mealName, calories.toString().toDouble(), protein.toString().toDouble(),
            carbs.toString().toDouble(), fats.toString().toDouble())
            //Create Current Meal
            mealViewModel.updateMeal(updatedMeal)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_reportsFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }

    }


    private fun inputCheck(mealName: String, calories: Editable, protein: Editable, carbs: Editable, fats: Editable): Boolean{
        return !(TextUtils.isEmpty(mealName) || calories.isEmpty() || protein.isEmpty()
                || carbs.isEmpty() || fats.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteMeal()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteMeal() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mealViewModel.deleteMeal(args.currentMeal)
            Toast.makeText(requireContext(),
                "Successfully removed: ${args.currentMeal.food_name}",
                Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_reportsFragment)
        }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete ${args.currentMeal.food_name}?")
        builder.setMessage("Are you sure you want to delete ${args.currentMeal.food_name}?")
        builder.create().show()
    }
}