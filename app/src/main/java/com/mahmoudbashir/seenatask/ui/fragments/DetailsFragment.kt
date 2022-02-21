package com.mahmoudbashir.seenatask.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {

    lateinit var detailsBinding:FragmentDetailsBinding
    var title:String? = null
    var img_url:String? = null
    var articleAbstract:String? = null

    lateinit var scalGest : ScaleGestureDetector
    private var mScaleFactor = 1.0f

    val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)


       // here we are getting passed data(Arguments data) from homeFragment in NavArgs
        title = args.title
        img_url = args.imgURL
        articleAbstract = args.articleAbstract



        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()
       /* detailsBinding.imgUrl.setOnTouchListener(object :View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                scalGest.onTouchEvent(event)
                return true
            }
        })

        scalGest = ScaleGestureDetector(context,object : ScaleGestureDetector.SimpleOnScaleGestureListener(){
            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                mScaleFactor *= scalGest.scaleFactor
                mScaleFactor = 0.1f.coerceAtLeast(mScaleFactor.coerceAtMost(10.0f))
                detailsBinding.imgUrl.scaleX = mScaleFactor
                detailsBinding.imgUrl.scaleY = mScaleFactor
                return true
            }
        })*/
    }

    private fun setUpViews() {
        detailsBinding.apply {
            txtTitle.text=title
            txtArticleAbstract.text=articleAbstract
            Picasso.get().load(img_url).placeholder(R.drawable.ic_launcher_background).into(imgUrl)

            imgUrl.setOnClickListener {
                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToFullScreenFragment(img_url!!))
            }
        }

    }

}