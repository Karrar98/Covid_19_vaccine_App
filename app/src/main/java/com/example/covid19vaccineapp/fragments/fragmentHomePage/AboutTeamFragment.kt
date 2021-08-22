package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.view.LayoutInflater
import com.example.covid19vaccineapp.databinding.FragmentAboutTeamBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class AboutTeamFragment : BaseFragment<FragmentAboutTeamBinding>() {

    override val LOG_TAG: String = "ABOUT_TEAM_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentAboutTeamBinding = FragmentAboutTeamBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }
}