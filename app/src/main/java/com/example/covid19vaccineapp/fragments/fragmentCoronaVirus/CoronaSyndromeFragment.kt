package com.example.covid19vaccineapp.fragments.fragmentCoronaVirus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentCoronaSyndromeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class CoronaSyndromeFragment : BaseFragment<FragmentCoronaSyndromeBinding>() {
    override val LOG_TAG: String = "CORONA_SYNDROME_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentCoronaSyndromeBinding =
        FragmentCoronaSyndromeBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }


}