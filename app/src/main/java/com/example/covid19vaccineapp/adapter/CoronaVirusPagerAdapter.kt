package com.example.covid19vaccineapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSyndromeFragment

class CoronaVirusPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 4

    override fun getItem(item: Int): Fragment {
        return when(item){
            0 -> CoronaFragment()
            1 -> CoronaReasonsFragment()
            2 -> CoronaSyndromeFragment()
            3 -> CoronaProtectionFragment()
            else -> CoronaFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}