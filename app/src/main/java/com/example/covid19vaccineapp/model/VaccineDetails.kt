package com.example.covid19vaccineapp.model

data class VaccineDetails(
    var country : String,
    var iso_code : String,
    var date : String,
    var total_vaccinations : Int?,
    var people_vaccinated : Int?,
    var people_fully_vaccinated : Int?,
    var daily_vaccinations_raw : Int?,
    var daily_vaccinations : Int?,
    var total_vaccinations_per_hundred : Double?,
    var people_vaccinated_per_hundred : Double?,
    var people_fully_vaccinated_per_hundred : Double?,
    var daily_vaccinations_per_million : Int?) {
}