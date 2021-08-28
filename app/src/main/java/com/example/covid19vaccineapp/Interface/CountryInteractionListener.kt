package com.example.covid19vaccineapp.Interface

import com.example.covid19vaccineapp.model.VaccineDetails

interface CountryInteractionListener {
    fun onClickItem(vaccine: VaccineDetails)
}