package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.model.VaccineDetails
import java.util.*
import java.util.Locale.getDefault

object DataManger {
    private val listVaccineDetails = mutableListOf<VaccineDetails>()
    val listLastDataCountry = mutableListOf<VaccineDetails>()
    private var listDataCountry = mutableMapOf<String, MutableList<VaccineDetails>>()
    private var searchDataCountry = mutableListOf<VaccineDetails>()

    fun addVaccineDetails(vaccineData: VaccineDetails) = listVaccineDetails.add(vaccineData)

    fun getListCountry() = listVaccineDetails.map { it.country }.toMutableSet()

    fun getCountry(country: String): MutableList<VaccineDetails> = listVaccineDetails.filter {
        it.country == country
    }.toMutableList()

    fun mapData() {
        getListCountry().forEach {
            listDataCountry[it] = getCountry(it)
        }
    }

    fun getLastDataCountry() = getListCountry().forEach { countryName ->
        listDataCountry[countryName]?.lastIndex?.let { listDataCountry[countryName]?.get(it) }
            ?.let {
                listLastDataCountry.add(
                    it
                )
            }
    }

    fun searchCountry(country: String) = listVaccineDetails.let {
        searchDataCountry = it.filter {
            it.country.lowercase(Locale.getDefault())
                .equals(country.lowercase(Locale.getDefault()), ignoreCase = true)
        }.toMutableList()
        it.associateBy(
            keySelector = { country.lowercase(getDefault()) },
            valueTransform = { searchDataCountry }
        )
    }

    fun getCountries(firstChar: Char) = listVaccineDetails.filter {
        it.country.startsWith(
            firstChar.toUpperCase()
        )
    }.map { it.country }.toMutableSet()
}