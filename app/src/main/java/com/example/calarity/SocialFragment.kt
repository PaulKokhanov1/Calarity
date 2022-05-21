package com.example.calarity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calarity.databinding.FragmentReportsBinding
import com.example.calarity.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentSocialBinding>(inflater, R.layout.fragment_social, container, false)
        return binding.root
    }

}