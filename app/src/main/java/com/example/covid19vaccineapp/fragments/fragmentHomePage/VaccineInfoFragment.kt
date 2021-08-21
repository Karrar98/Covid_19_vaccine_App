package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.view.LayoutInflater
import com.example.covid19vaccineapp.databinding.FragmentVaccineInfoBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import android.text.method.LinkMovementMethod

class VaccineInfoFragment : BaseFragment<FragmentVaccineInfoBinding>() {

    override val LOG_TAG: String = "VACCINE_INFO_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentVaccineInfoBinding = FragmentVaccineInfoBinding::inflate

    override fun setup() {
//        binding.
//        getapp.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun addCallBack() {

    }

}