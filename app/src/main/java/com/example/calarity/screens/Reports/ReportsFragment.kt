package com.example.calarity.screens.Reports

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        val adapter = ListAdapter(findNavController())
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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteAllMeals()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllMeals() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mealViewModel.deleteAllMeals()
            Toast.makeText(requireContext(),
                "Successfully removed everything",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}