package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.model.VaccineDetails
import java.util.*
import java.util.Locale.getDefault

object DataManger {
    private val vaccineDetailsList = mutableListOf<VaccineDetails>()
    private var listDataCountry = mutableListOf<VaccineDetails>()

    fun addVaccineDetails(vaccineData: VaccineDetails) = vaccineDetailsList.add(vaccineData)

    fun getVaccineDetails() = vaccineDetailsList

    fun getCountry(country: String) = vaccineDetailsList.let {
        listDataCountry = it.filter {
            it.country.lowercase(Locale.getDefault()).equals(country.lowercase(Locale.getDefault()), ignoreCase = true)
        }.toMutableList()
        it.associateBy(
            keySelector = { country.lowercase(getDefault()) },
            valueTransform = { listDataCountry }
        )
    }
}