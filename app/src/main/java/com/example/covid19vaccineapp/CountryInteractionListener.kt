package com.example.covid19vaccineapp

import com.example.covid19vaccineapp.model.VaccineDetails

interface CountryInteractionListener {
    fun onClickItem(vaccine: VaccineDetails)
}