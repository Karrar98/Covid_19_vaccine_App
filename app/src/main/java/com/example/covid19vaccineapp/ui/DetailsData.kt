package com.example.covid19vaccineapp.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19vaccineapp.Utilse.Constants
import com.example.covid19vaccineapp.databinding.DetailsDataBinding
import com.example.covid19vaccineapp.model.VaccineDetails
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS

class DetailsData : AppCompatActivity() {

    val LOG_TAG: String = "DETAILS_DATA"

    private lateinit var binding: DetailsDataBinding
    private lateinit var vaccine: VaccineDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vaccine = intent.getSerializableExtra(Constants.VACCINE) as VaccineDetails
        initDataSet()
    }

    private fun initDataSet() {
        binding.apply {
            txtPeopleVaccine.text = vaccine.people_vaccinated.toInt().toString()
            txtPeopleFullyVaccine.text = vaccine.people_fully_vaccinated.toInt().toString()
            txtCountryName.text = vaccine.country
            txtIsoCode.text = vaccine.iso_code
            txtTotalVaccine.text = vaccine.total_vaccinations.toInt().toString()
            
            val visitors: ArrayList<PieEntry> = arrayListOf()
            visitors.add(PieEntry(vaccine.total_vaccinations_per_hundred.toFloat(),"Total Vaccinations"))
            visitors.add(PieEntry(vaccine.people_vaccinated_per_hundred.toFloat(), "People Vaccinated"))
            visitors.add(PieEntry(vaccine.people_fully_vaccinated_per_hundred.toFloat(), "People Fully Vaccinated"))
//            visitors.add(PieEntry(vaccine.daily_vaccinations_per_million.toFloat(), "Daily Vaccinated"))


            val pieDataSet = PieDataSet(visitors, "Corona Vaccine")
            pieDataSet.colors = COLORFUL_COLORS.toMutableList()
            pieDataSet.valueTextColor = Color.BLACK
            pieDataSet.valueTextSize = 16f

            val pieData = PieData(pieDataSet)
            pieChartCountry.apply {
                data = pieData
                description.isEnabled = false
                centerText = "Corona Vaccine"
                animate()
            }
            
        }
    }
}