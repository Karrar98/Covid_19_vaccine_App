package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.view.LayoutInflater
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.Utilse.DataList
import com.example.covid19vaccineapp.adapter.CoronaAdapter
import com.example.covid19vaccineapp.adapter.CoronaMultiViewAdapter
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding =
        FragmentCoronaVirusBinding::inflate

    override fun setup() {
        initRecyclerViewReasons()
        initRecyclerViewSymptoms()
        initRecyclerViewProtection()
    }

    private fun initRecyclerViewReasons() {
        val adapter = CoronaAdapter(DataList().listTitleReasons, DataList().listImageReasons)
        binding!!.recyclerReasons.adapter = adapter
    }

    private fun initRecyclerViewSymptoms() {
        val adapter = CoronaAdapter(DataList().listTitleSymptoms, DataList().listImageSymptoms)
        binding!!.recyclerSymptoms.adapter = adapter
    }

    private fun initRecyclerViewProtection() {
        val adapter = CoronaMultiViewAdapter(DataList().listTitleProtection, DataList().listImageProtection)
        binding!!.recyclerProtection.adapter = adapter
    }

    override fun addCallBack() {

    }
}