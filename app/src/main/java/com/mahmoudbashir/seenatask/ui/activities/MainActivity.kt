package com.mahmoudbashir.seenatask.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.databinding.ActivityMainBinding
import com.mahmoudbashir.seenatask.repository.Repository
import com.mahmoudbashir.seenatask.viewModel.HomeViewModel
import com.mahmoudbashir.seenatask.viewModel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    private val repo : Repository = Repository()
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val viewModelFactory = ViewModelFactory(application,repo)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
    }
}