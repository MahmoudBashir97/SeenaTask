package com.mahmoudbashir.seenatask

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mahmoudbashir.seenatask.databinding.FragmentFullScreenBinding
import com.squareup.picasso.Picasso


class FullScreenFragment : Fragment() {
    lateinit var fullScreenBinding: FragmentFullScreenBinding
    val args:FullScreenFragmentArgs by navArgs()
    var img_url:String? = null

    lateinit var scalGest : ScaleGestureDetector
    private var mScaleFactor = 1.0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fullScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_full_screen, container, false)

        img_url = args.imgURL

        return fullScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpScaleOnImageView()
    }

    private fun setUpScaleOnImageView() {
        scalGest = ScaleGestureDetector(context,object : ScaleGestureDetector.SimpleOnScaleGestureListener(){
            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                mScaleFactor *= scalGest.scaleFactor
                mScaleFactor = 0.1f.coerceAtLeast(mScaleFactor.coerceAtMost(10.0f))
                fullScreenBinding.imgPic.scaleX = mScaleFactor
                fullScreenBinding.imgPic.scaleY = mScaleFactor
                return true
            }
        })
    }

    private fun setUpViews() {
        fullScreenBinding.apply {
            Picasso.get().load(img_url).into(imgPic)

            imgPic.setOnTouchListener(object :View.OnTouchListener{
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    scalGest.onTouchEvent(event)
                    return true
                }
            })
        }
    }
}