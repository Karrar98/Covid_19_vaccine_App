package com.example.covid19vaccineapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corona_virus, container, false)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCoronaVirusBinding = FragmentCoronaVirusBinding::inflate

    override fun setUp() {

    }

    override fun addCallBack() {

    }
}