package com.example.calarity.screens.Foods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.calarity.R
import com.example.calarity.databinding.FragmentFoodsBinding
import com.example.calarity.screens.Diary.DiaryViewModel

class FoodsFragment : Fragment() {

    //reference to our ViewModel for Foods Fragment
    private lateinit var viewModel: FoodsViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFoodsBinding>(inflater,
            R.layout.fragment_foods, container, false)

        //initialize the ViewModel
        viewModel = ViewModelProvider(this).get(FoodsViewModel::class.java)

        return binding.root
    }

}