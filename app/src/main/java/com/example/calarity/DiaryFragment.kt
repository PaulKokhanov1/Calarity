package com.example.calarity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calarity.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDiaryBinding>(inflater, R.layout.fragment_diary, container, false)
        return binding.root
    }

}