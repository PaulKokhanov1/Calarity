package com.example.calarity.screens.Diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addFragment)
        }


        return binding.root
    }

}