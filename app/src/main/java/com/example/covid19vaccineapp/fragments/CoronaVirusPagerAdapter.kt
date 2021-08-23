package com.example.covid19vaccineapp.fragments

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSyndromeFragment

class CoronaVirusPagerAdapter(fm: FragmentManager, var binding: FragmentCoronaVirusBinding) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 4

    override fun getItem(item: Int): Fragment {
        return when(item){
            0 -> { binding.swipeLeft.visibility = View.INVISIBLE
                CoronaFragment() }
            1 -> { binding.swipeLeft.visibility = View.VISIBLE
                CoronaReasonsFragment() }
            2 -> { binding.swipeLeft.visibility = View.VISIBLE
                CoronaSyndromeFragment() }
            3 -> { binding.swipeLeft.visibility = View.VISIBLE
                CoronaProtectionFragment() }
            else -> { binding.swipeLeft.visibility = View.INVISIBLE
                CoronaFragment() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}