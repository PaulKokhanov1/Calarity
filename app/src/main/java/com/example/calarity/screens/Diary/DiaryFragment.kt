package com.example.calarity.screens.Diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.calarity.R
import com.example.calarity.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    //reference to our ViewModel for Diary Fragment
    private lateinit var viewModel: DiaryViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDiaryBinding>(inflater,
            R.layout.fragment_diary, container, false)

        //initialize the ViewModel
        viewModel = ViewModelProvider(this).get(DiaryViewModel::class.java)


        //could make this into a when statement
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addFragment)
        }
        binding.breakfastAddBtn.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addBreakfastFragment)
            Toast.makeText(requireContext(), "breakfast_btn", Toast.LENGTH_LONG).show()
        }
        binding.lunchAddBtn.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addLunchFragment)
            Toast.makeText(requireContext(), "lunch_btn", Toast.LENGTH_LONG).show()
        }
        binding.dinnerAddBtn.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addDinnerFragment)
            Toast.makeText(requireContext(), "dinner_btn", Toast.LENGTH_LONG).show()
        }


        return binding.root
    }

}