package com.example.covid19vaccineapp.fragments.fragmentCoronaVirus

import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentCoronaBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class CoronaFragment : BaseFragment<FragmentCoronaBinding>() {

    override val LOG_TAG: String = "CORONA_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentCoronaBinding = FragmentCoronaBinding::inflate

    override fun setup() {
        binding?.apply {
            imageVirusBig.startAnimation(
                AnimationUtils.loadAnimation(activity, R.anim.fedeout)
            )
            imageVirusSmall.startAnimation(
                AnimationUtils.loadAnimation(activity, R.anim.fedeout)
            )
        }
    }

    override fun addCallBack() {

    }

}