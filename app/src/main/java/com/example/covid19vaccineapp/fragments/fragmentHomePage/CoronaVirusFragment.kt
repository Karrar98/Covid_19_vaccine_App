package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.adapter.CoronaVirusPagerAdapter

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding = FragmentCoronaVirusBinding::inflate

    private lateinit var coronaVirusPagerAdapter: CoronaVirusPagerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coronaVirusPagerAdapter = CoronaVirusPagerAdapter(childFragmentManager)
        binding!!.coronaPageView.adapter = coronaVirusPagerAdapter
    }

    override fun setup() {

    }

    override fun addCallBack() {

    }
}