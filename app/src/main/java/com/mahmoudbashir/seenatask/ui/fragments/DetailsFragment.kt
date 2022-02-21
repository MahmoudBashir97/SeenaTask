package com.mahmoudbashir.seenatask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {

    lateinit var detailsBinding:FragmentDetailsBinding
    var title:String? = null
    var img_url:String? = null
    var articleAbstract:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
       // here we are getting passed data(Arguments data) from homeFragment in NavArgs
        title = arguments?.let { DetailsFragmentArgs.fromBundle(it).title }
        img_url = arguments?.let { DetailsFragmentArgs.fromBundle(it).imgUrl }
        articleAbstract = arguments?.let { DetailsFragmentArgs.fromBundle(it).articleAbstract }



        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()

    }

    private fun setUpViews() {
        detailsBinding.apply {
            txtTitle.text=title
            txtArticleAbstract.text=articleAbstract
            Picasso.get().load(img_url).placeholder(R.drawable.ic_launcher_background).into(imgUrl)
        }

    }

}