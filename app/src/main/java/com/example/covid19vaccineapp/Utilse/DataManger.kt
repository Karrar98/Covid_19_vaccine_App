package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.model.VaccineDetails
import java.util.*
import java.util.Locale.getDefault

object DataManger {
    private val vaccineDetailsList = mutableListOf<VaccineDetails>()
    private var listDataCountry = mutableListOf<VaccineDetails>()
    private var countryIndex = 0

    fun addVaccineDetails(vaccineData: VaccineDetails) = vaccineDetailsList.add(vaccineData)

    fun getListCountry(): MutableSet<String> = vaccineDetailsList.map { it.country }.toMutableSet()

    fun getVaccineDetails() = vaccineDetailsList

    fun getCountry(country: String) = vaccineDetailsList.let {
        listDataCountry = it.filter {
            it.country.lowercase(Locale.getDefault())
                .equals(country.lowercase(Locale.getDefault()), ignoreCase = true)
        }.toMutableList()
        it.associateBy(
            keySelector = { country.lowercase(getDefault()) },
            valueTransform = { listDataCountry }
        )
    }

    fun nextCountry() {
        countryIndex++
    }

    fun previousCountry() {
        countryIndex--
    }

    fun getCountryIndex(): Int {
        if (countryIndex == -1) {
            countryIndex = getListCountry().size-1
        } else if (countryIndex > getListCountry().size -1) {
            countryIndex = 0
        }
        return countryIndex
    }

    fun getDataCountry(countryIndex: Int) : VaccineDetails {
        lateinit var data: VaccineDetails
        getCountry(getListCountry().elementAt(countryIndex)).forEach { dataCountry ->
            data = dataCountry.value[dataCountry.value.size - 1]
        }
        return data
    }
    
}