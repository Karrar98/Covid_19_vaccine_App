package com.example.covid19vaccineapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentAboutTeamBinding

class AboutTeamFragment : BaseFragment<FragmentAboutTeamBinding>() {

    override val LOG_TAG: String = "ABOUT_TEAM_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_team, container, false)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAboutTeamBinding = FragmentAboutTeamBinding::inflate

    override fun setUp() {

    }

    override fun addCallBack() {

    }
}