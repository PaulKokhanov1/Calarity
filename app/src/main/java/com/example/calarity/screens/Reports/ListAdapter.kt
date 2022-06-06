package com.example.calarity.screens.Reports

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.calarity.R
import com.example.calarity.database.Meal
import com.example.calarity.databinding.CustomRowBinding

class ListAdapter(val findNavController: NavController) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private var mealList = emptyList<Meal>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        return MyViewHolder(CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val currentItem = mealList[position]
        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.mealTxt.text = currentItem.food_name
        holder.binding.caloriesTxt.text = currentItem.Calories.toString()
        holder.binding.proteinTxt.text = currentItem.Protein.toString()
        holder.binding.carbsTxt.text = currentItem.Carbs.toString()
        holder.binding.fatsTxt.text = currentItem.Fats.toString()

        holder.binding.rowLayout.setOnClickListener {

            val action = ReportsFragmentDirections.actionReportsFragmentToUpdateFragment(currentItem)
            findNavController.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    fun setData(meal: List<Meal>){
        this.mealList = meal
        notifyDataSetChanged()
    }

}