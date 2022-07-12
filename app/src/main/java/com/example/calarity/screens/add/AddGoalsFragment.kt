package com.example.calarity.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calarity.R
import com.example.calarity.databinding.FragmentAddGoalsBinding

class AddGoalsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentAddGoalsBinding>(inflater,
            R.layout.fragment_add_goals, container, false)

        return binding.root
    }

}