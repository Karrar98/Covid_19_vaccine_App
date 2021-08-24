package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.view.LayoutInflater
import com.example.covid19vaccineapp.databinding.FragmentVaccineInfoBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class VaccineInfoFragment : BaseFragment<FragmentVaccineInfoBinding>() {

    override val LOG_TAG: String = "VACCINE_INFO_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentVaccineInfoBinding = FragmentVaccineInfoBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }

}