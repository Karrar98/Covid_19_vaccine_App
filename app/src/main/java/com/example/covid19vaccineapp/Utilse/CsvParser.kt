package com.example.covid19vaccineapp.Utilse

import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.COUNTRY
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.DAILY_VACCINATIONS
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.DAILY_VACCINATIONS_PER_MILLION
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.DAILY_VACCINATIONS_RAW
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.DATE
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.ISO_CODE
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED_PER_HUNDRED
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.PEOPLE_VACCINATED
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.TOTAL_VACCINATIONS
import com.example.covid19vaccineapp.Utilse.Constants.ColumnVaccineData.TOTAL_VACCINATIONS_PER_HUNDRED
import com.example.covid19vaccineapp.model.VaccineDetails

class CsvParser {
    fun parserData(line : String) : VaccineDetails {
        val token =  line.split(",")
        return VaccineDetails(
            country = token[COUNTRY],
            iso_code = token[ISO_CODE],
            date = token[DATE],
            total_vaccinations = token[TOTAL_VACCINATIONS].toIntOrNull() ?: 0,
            people_vaccinated = token[PEOPLE_VACCINATED].toIntOrNull() ?: 0,
            people_fully_vaccinated = token[PEOPLE_FULLY_VACCINATED].toIntOrNull() ?: 0,
            daily_vaccinations_raw = token[DAILY_VACCINATIONS_RAW].toIntOrNull() ?: 0,
            daily_vaccinations = token[DAILY_VACCINATIONS].toIntOrNull() ?: 0,
            total_vaccinations_per_hundred = token[TOTAL_VACCINATIONS_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_vaccinated_per_hundred = token[Constants.ColumnVaccineData.PEOPLE_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_fully_vaccinated_per_hundred = token[PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            daily_vaccinations_per_million = token[DAILY_VACCINATIONS_PER_MILLION].toIntOrNull() ?: 0,
        )
    }
}