package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.view.LayoutInflater
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.adapter.CountryAdapter
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        val adapter = CountryAdapter(DataManger.getDataCountry())
        binding!!.recyclerCountry.adapter = adapter

    }

    override fun addCallBack() {
    }
}