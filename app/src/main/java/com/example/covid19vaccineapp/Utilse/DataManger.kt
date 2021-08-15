package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.model.VaccineDetails

object DataManger {
    private val vaccineDetailsList = mutableListOf<VaccineDetails>()

    fun addVaccineDetails(vaccineData : VaccineDetails) = vaccineDetailsList.add(vaccineData)
}