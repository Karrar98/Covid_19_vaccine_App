package com.example.covid19vaccineapp.fragments.fragmentCoronaVirus

import android.view.LayoutInflater
import com.example.covid19vaccineapp.adapter.CoronaAdapter
import com.example.covid19vaccineapp.databinding.FragmentCoronaSymptomsBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class CoronaSymptomsFragment : BaseFragment<FragmentCoronaSymptomsBinding>() {
    override val LOG_TAG: String = "CORONA_SYNDROME_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentCoronaSymptomsBinding =
        FragmentCoronaSymptomsBinding::inflate

    private val listSymptoms = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven")
    override fun setup() {
        val adapter = CoronaAdapter(listSymptoms)
        binding!!.recyclerSymptoms.adapter = adapter
    }

    override fun addCallBack() {

    }


}