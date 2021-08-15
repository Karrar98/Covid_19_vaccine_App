package com.example.covid19vaccineapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentVaccineInfoBinding

class VaccineInfoFragment : BaseFragment<FragmentVaccineInfoBinding>() {

    override val LOG_TAG: String = "VACCINE_INFO_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vaccine_info, container, false)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVaccineInfoBinding = FragmentVaccineInfoBinding::inflate

    override fun setUp() {

    }

    override fun addCallBack() {

    }

}