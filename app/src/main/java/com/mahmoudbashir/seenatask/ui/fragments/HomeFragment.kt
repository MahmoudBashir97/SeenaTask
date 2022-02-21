package com.mahmoudbashir.seenatask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.databinding.FragmentHomeBinding
import com.mahmoudbashir.seenatask.viewModel.HomeViewModel
import javax.inject.Inject


class HomeFragment : Fragment() {
    lateinit var homeBinding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}