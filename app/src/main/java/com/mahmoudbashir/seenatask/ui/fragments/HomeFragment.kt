package com.mahmoudbashir.seenatask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.adapters.PopularAdapter
import com.mahmoudbashir.seenatask.databinding.FragmentHomeBinding
import com.mahmoudbashir.seenatask.ui.activities.MainActivity
import com.mahmoudbashir.seenatask.viewModel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeFragment : Fragment() , PopularAdapter.ItemClickInterface{
    lateinit var homeBinding: FragmentHomeBinding
    lateinit var pop_adapter:PopularAdapter

    lateinit var viewModel:HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewModel = (activity as MainActivity).viewModel

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        getDataToViews()

    }

    private fun getDataToViews() {
        homeBinding.isLoading = true

            viewModel.getPopular()

        viewModel.pop.observe(viewLifecycleOwner,{
            model ->
            if (model != null){
                homeBinding.isLoading = false
                pop_adapter.differ.submitList(model.results)
            }
        })

    }

    private fun setUpRecyclerView() {
        pop_adapter = PopularAdapter(this)
        homeBinding.recNews.apply {
            setHasFixedSize(true)
            adapter = pop_adapter
        }
    }

    override fun onClick(position: Int, imgUrl: String, title: String, article_abstract: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(imgUrl,title,article_abstract))
    }
}