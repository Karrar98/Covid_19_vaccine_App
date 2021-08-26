package com.example.covid19vaccineapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CoronaVirusPagerAdapter(fm: Fragment, private val listFragment: List<Fragment>) : FragmentStateAdapter(fm) {
    override fun getItemCount() = listFragment.size

    override fun createFragment(position: Int) = listFragment[position]

}