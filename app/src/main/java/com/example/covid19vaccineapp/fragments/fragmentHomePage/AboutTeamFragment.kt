package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.adapter.TeamAdapter
import com.example.covid19vaccineapp.databinding.FragmentAboutTeamBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.model.Team

class AboutTeamFragment : BaseFragment<FragmentAboutTeamBinding>() {

    override val LOG_TAG: String = "ABOUT_TEAM_FRAGMENT"

    private val teamData = mutableListOf<Team>()

    override val bindingInflater: (LayoutInflater) -> FragmentAboutTeamBinding = FragmentAboutTeamBinding::inflate

    override fun setup() {
        initDataTeam()
        val adapter = TeamAdapter(teamData)
        binding!!.recyclerViewTeam.adapter = adapter
    }

    override fun addCallBack() {

    }

    @SuppressLint("StringFormatInvalid")
    fun initDataTeam(){
        teamData.add(Team(getString(R.string.mohammed_maher), getString(R.string.team_member),R.drawable.moh_img))
        teamData.add(Team(getString(R.string.karrar_jabbar), getString(R.string.team_member),R.drawable.kar_img))
        teamData.add(Team(getString(R.string.ruqaya_nia_ma), getString(R.string.team_member),R.drawable.rug_img))
        teamData.add(Team(getString(R.string.zainab_mahmood), getString(R.string.team_member),R.drawable.zi_img))
        teamData.add(Team(getString(R.string.shahlaa_haider), getString(R.string.team_member),R.drawable.shahlaa_img))
        teamData.add(Team(getString(R.string.tamara_mouneer), getString(R.string.team_member),R.drawable.tamara_img))
    }
}