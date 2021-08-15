package com.example.covid19vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.covid19vaccineapp.Utilse.Constants
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.HOME_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.SEARCH_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.CORONA_VIRUS_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.VACCINE_INFO_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.ABOUT_TEAM_PAGE
import com.example.covid19vaccineapp.Utilse.CsvParser
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.ActivityHomeBinding
import com.example.covid19vaccineapp.fragment.*
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeActivity : AppCompatActivity() {

    val LOG_TAG: String = "HOME_ACTIVITY"

    lateinit var binding : ActivityHomeBinding

    var myHomeFragment = HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startSplashScreen()
        setup()
        addCallBack()
    }

    private fun startSplashScreen() {
        Handler().postDelayed(Runnable {
            binding.lottieCovid19Vaccine.visibility = View.INVISIBLE
            binding.fragmentContainerView.visibility = View.VISIBLE
            binding.meowBottomNavigation.visibility = View.VISIBLE
        },5000)
    }

    private fun setUpBottomNavigation() {
        binding.meowBottomNavigation.apply {
            add(MeowBottomNavigation.Model(HOME_PAGE, R.drawable.ic_home))
            add(MeowBottomNavigation.Model(SEARCH_PAGE, R.drawable.ic_search))
            add(MeowBottomNavigation.Model(CORONA_VIRUS_PAGE, R.drawable.ic_coronavirus))
            add(MeowBottomNavigation.Model(VACCINE_INFO_PAGE, R.drawable.ic_info))
            add(MeowBottomNavigation.Model(ABOUT_TEAM_PAGE, R.drawable.ic_supervisor))
            setOnClickMenuListener {
                when(it.id){
                    HOME_PAGE -> setFragment(HomeFragment())
                    SEARCH_PAGE -> setFragment(SearchFragment())
                    CORONA_VIRUS_PAGE -> setFragment(CoronaVirusFragment())
                    VACCINE_INFO_PAGE -> setFragment(VaccineInfoFragment())
                    ABOUT_TEAM_PAGE -> setFragment(AboutTeamFragment())
                }
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainerView.id, fragment)
        transaction.commit()
    }

    fun setup() {
        setFragment(HomeFragment())
        setUpBottomNavigation()
        openFile()
    }

    fun addCallBack() {

    }

    private fun openFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
//            val currentVaccineData = CsvParser().parserData(it)
//            DataManger.addVaccineDetails(currentVaccineData)
        }
    }

}