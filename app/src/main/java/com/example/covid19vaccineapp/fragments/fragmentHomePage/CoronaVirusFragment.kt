package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.example.covid19vaccineapp.adapter.CoronaVirusPagerAdapter
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSymptomsFragment

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding =
        FragmentCoronaVirusBinding::inflate

    private lateinit var coronaVirusPagerAdapter: CoronaVirusPagerAdapter

    private val listFragment = listOf<Fragment>(
        CoronaFragment(), CoronaReasonsFragment(),
        CoronaSymptomsFragment(), CoronaProtectionFragment()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewPager()
    }

    override fun setup() {

    }

    override fun addCallBack() {

    }

    private fun initViewPager() {
        coronaVirusPagerAdapter = CoronaVirusPagerAdapter(childFragmentManager, listFragment)
        binding!!.coronaViewpager.adapter = coronaVirusPagerAdapter
    }
}