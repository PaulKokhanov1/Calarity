package com.example.calarity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calarity.databinding.FragmentDiaryBinding
import com.example.calarity.databinding.FragmentReportsBinding

class ReportsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentReportsBinding>(inflater, R.layout.fragment_reports, container, false)
        return binding.root
    }


}