package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.model.VaccineDetails

class CsvParser {
    fun parserData(line : String) : VaccineDetails {
        val token =  line.split(",")
        return VaccineDetails(
            country = token[Constants.ColumnVaccineData.COUNTRY],
            iso_code = token[Constants.ColumnVaccineData.ISO_CODE],
            date = token[Constants.ColumnVaccineData.DATE],
            total_vaccinations = token[Constants.ColumnVaccineData.TOTAL_VACCINATIONS].toInt(),
            people_vaccinated = token[Constants.ColumnVaccineData.PEOPLE_VACCINATED].toInt(),
            people_fully_vaccinated = token[Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED].toInt(),
            daily_vaccinations_raw = token[Constants.ColumnVaccineData.DAILY_VACCINATIONS_RAW].toInt(),
            daily_vaccinations = token[Constants.ColumnVaccineData.DAILY_VACCINATIONS].toInt(),
            total_vaccinations_per_hundred = token[Constants.ColumnVaccineData.TOTAL_VACCINATIONS_PER_HUNDRED].toDouble(),
            people_vaccinated_per_hundred = token[Constants.ColumnVaccineData.PEOPLE_VACCINATED_PER_HUNDRED].toDouble(),
            people_fully_vaccinated_per_hundred = token[Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDouble(),
            daily_vaccinations_per_million = token[Constants.ColumnVaccineData.DAILY_VACCINATIONS_PER_MILLION].toInt(),
        )
    }
}