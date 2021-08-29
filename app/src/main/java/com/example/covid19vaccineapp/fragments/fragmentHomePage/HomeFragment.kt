package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.content.Intent
import android.view.LayoutInflater
import com.example.covid19vaccineapp.Interface.CountryInteractionListener
import com.example.covid19vaccineapp.Utilse.Constants
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.adapter.CountryAdapter
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.model.VaccineDetails
import com.example.covid19vaccineapp.ui.DetailsData

class HomeFragment : BaseFragment<FragmentHomeBinding>(), CountryInteractionListener {

    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        DataManger.mapData()
        DataManger.getLastDataCountry()
        val adapter = CountryAdapter(DataManger.listLastDataCountry, this)
        binding!!.recyclerCountry.adapter = adapter
    }

    override fun addCallBack() {
    }

    override fun onClickItem(vaccine: VaccineDetails) {
        val intent = Intent(context?.applicationContext, DetailsData::class.java)
        startActivity(intent)
//        intent.putExtra(Constants.VACCINE, vaccine)
    }

}