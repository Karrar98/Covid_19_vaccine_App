package com.example.covid19vaccineapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class CoronaVirusPagerAdapter(fm: FragmentManager, private val listFragment: List<Fragment>) : FragmentStatePagerAdapter(fm) {

    override fun getCount() = listFragment.size

    override fun getItem(position: Int) = listFragment[position]

}