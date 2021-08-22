package com.example.covid19vaccineapp.Utilse

object Constants {
    object ColumnVaccineData {
        const val COUNTRY = 0
        const val ISO_CODE = 1
        const val DATE = 2
        const val TOTAL_VACCINATIONS = 3
        const val PEOPLE_VACCINATED = 4
        const val PEOPLE_FULLY_VACCINATED = 5
        const val DAILY_VACCINATIONS_RAW = 6
        const val DAILY_VACCINATIONS = 7
        const val TOTAL_VACCINATIONS_PER_HUNDRED = 8
        const val PEOPLE_VACCINATED_PER_HUNDRED = 9
        const val PEOPLE_FULLY_VACCINATED_PER_HUNDRED = 10
        const val DAILY_VACCINATIONS_PER_MILLION = 11

    }

    object BottomNavigationIndex {
        const val HOME_PAGE = 0
        const val SEARCH_PAGE = 1
        const val CORONA_VIRUS_PAGE = 2
        const val VACCINE_INFO_PAGE = 3
        const val ABOUT_TEAM_PAGE = 4
    }

    object StatusFragment {
        const val ADD_FRAGMENT : Int = 0
        const val REPLACE_FRAGMENT : Int = 0
    }

    object CoronaTabIndex{
        const val CORONA : Int = 0
        const val CORONA_REASONS : Int = 1
        const val CORONA_SYNDROME : Int = 2
        const val CORONA_PROTECTION : Int = 3
    }
}