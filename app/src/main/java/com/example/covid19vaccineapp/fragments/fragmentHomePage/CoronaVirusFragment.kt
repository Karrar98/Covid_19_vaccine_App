package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.adapter.CoronaVirusPagerAdapter
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSyndromeFragment
import com.google.android.material.tabs.TabLayoutMediator

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding =
        FragmentCoronaVirusBinding::inflate

    private lateinit var coronaVirusPagerAdapter: CoronaVirusPagerAdapter

    private val listFragment = listOf<Fragment>(
        CoronaFragment(), CoronaReasonsFragment(),
        CoronaSyndromeFragment(), CoronaProtectionFragment()
    )

    private val listTabTitle = listOf<String>("Corona", "Reasons", "Syndrome", "Protection")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun setup() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        binding?.apply {
            TabLayoutMediator(coronaTabLayout, coronaViewpager) { tab, position ->
                tab.text = listTabTitle[position]
            }.attach()
        }

    }

    private fun initViewPager() {
        coronaVirusPagerAdapter = CoronaVirusPagerAdapter(requireParentFragment(), listFragment)
        binding!!.coronaViewpager.adapter = coronaVirusPagerAdapter
    }

    override fun addCallBack() {

    }
}