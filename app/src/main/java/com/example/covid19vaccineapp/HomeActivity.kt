package com.example.covid19vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.HOME_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.SEARCH_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.CORONA_VIRUS_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.VACCINE_INFO_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.BottomNavigationIndex.ABOUT_TEAM_PAGE
import com.example.covid19vaccineapp.Utilse.Constants.StatusFragment.ADD_FRAGMENT
import com.example.covid19vaccineapp.Utilse.Constants.StatusFragment.REPLACE_FRAGMENT
import com.example.covid19vaccineapp.Utilse.CsvParser
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.ActivityHomeBinding
import com.example.covid19vaccineapp.fragments.fragmentHomePage.*
import java.io.BufferedReader
import java.io.InputStreamReader
import android.view.Window
import android.view.WindowManager

class HomeActivity : AppCompatActivity() {

    val LOG_TAG: String = "HOME_ACTIVITY"

    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val window: Window = this.window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        window.statusBarColor = this.resources.getColor(R.color.white)

        startSplashScreen()
        setup()
        addCallBack()
    }

    private fun startSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            binding.lottieCovid19Vaccine.visibility = View.INVISIBLE
            binding.fragmentContainerView.visibility = View.VISIBLE
            binding.meowBottomNavigation.visibility = View.VISIBLE
        },5000)
    }

    fun setup() {
        setFragment(HomeFragment(), ADD_FRAGMENT)
        setUpBottomNavigation()
        openFile()
    }

    private fun setUpBottomNavigation() {
        binding.meowBottomNavigation.apply {
            add(MeowBottomNavigation.Model(HOME_PAGE, R.drawable.ic_home))
            add(MeowBottomNavigation.Model(SEARCH_PAGE, R.drawable.ic_search))
            add(MeowBottomNavigation.Model(CORONA_VIRUS_PAGE, R.drawable.ic_virus4))
            add(MeowBottomNavigation.Model(VACCINE_INFO_PAGE, R.drawable.ic_info))
            add(MeowBottomNavigation.Model(ABOUT_TEAM_PAGE, R.drawable.ic_supervisor))
            show(HOME_PAGE, true)
            setOnClickMenuListener {
                selectMenuBottomNavigation(it)
                }
            }
        }

    private fun selectMenuBottomNavigation(model: MeowBottomNavigation.Model) {
        when(model.id){
            HOME_PAGE -> setFragment(HomeFragment(), REPLACE_FRAGMENT)
            SEARCH_PAGE -> setFragment(SearchFragment(), REPLACE_FRAGMENT)
            CORONA_VIRUS_PAGE -> setFragment(CoronaVirusFragment(), REPLACE_FRAGMENT)
            VACCINE_INFO_PAGE -> setFragment(VaccineInfoFragment(), REPLACE_FRAGMENT)
            ABOUT_TEAM_PAGE -> setFragment(AboutTeamFragment(), REPLACE_FRAGMENT)
    }
}

    private fun setFragment(fragment: Fragment, status_fragment: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        when(status_fragment){
            ADD_FRAGMENT -> transaction.add(binding.fragmentContainerView.id, fragment)
            REPLACE_FRAGMENT -> transaction.replace(binding.fragmentContainerView.id, fragment)
        }
        transaction.commit()
    }

    fun addCallBack() {

    }

    fun openFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            val currentVaccineData = CsvParser().parserData(it)
            DataManger.addVaccineDetails(currentVaccineData)
        }
    }

}