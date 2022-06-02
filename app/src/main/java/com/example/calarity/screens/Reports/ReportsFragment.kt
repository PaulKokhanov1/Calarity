package com.example.calarity.screens.Reports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calarity.R
import com.example.calarity.database.Meal
import com.example.calarity.database.MealViewModel
import com.example.calarity.databinding.FragmentReportsBinding
import com.example.calarity.screens.Diary.DiaryViewModel

class ReportsFragment : Fragment() {


    //reference to our ViewModel for Reports Fragment
    private lateinit var viewModel: ReportsViewModel

    private lateinit var mealViewModel: MealViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentReportsBinding>(inflater,
            R.layout.fragment_reports, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //MealViewModel
        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)
        mealViewModel.readAllData.observe(viewLifecycleOwner, Observer { meal ->
            adapter.setData(meal)
        })

        //initialize the ViewModel
        viewModel = ViewModelProvider(this).get(ReportsViewModel::class.java)

        return binding.root
    }


}