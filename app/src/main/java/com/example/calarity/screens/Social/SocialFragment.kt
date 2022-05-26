package com.example.calarity.screens.Social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.calarity.R
import com.example.calarity.databinding.FragmentSocialBinding
import com.example.calarity.screens.Diary.DiaryViewModel


class SocialFragment : Fragment() {


    //reference to our ViewModel for Social Fragment
    private lateinit var viewModel: SocialViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentSocialBinding>(inflater,
            R.layout.fragment_social, container, false)

        //initialize the ViewModel
        viewModel = ViewModelProvider(this).get(SocialViewModel::class.java)

        return binding.root
    }

}