package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import com.example.covid19vaccineapp.Interface.CountryInteractionListener
import com.example.covid19vaccineapp.Utilse.Constants
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.adapter.CountryAdapter
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.model.VaccineDetails
import com.example.covid19vaccineapp.ui.DetailsData
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class HomeFragment : BaseFragment<FragmentHomeBinding>(), CountryInteractionListener {

    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        DataManger.mapData()
        DataManger.getLastDataCountry()
        val adapter = CountryAdapter(DataManger.listLastDataCountry, this)
        binding!!.recyclerCountry.adapter = adapter
        setUpBarChar()
    }

    private fun setUpBarChar() {
        DataManger.getTopVaccineCountry()
        val dataCountry = DataManger.listLastDataCountry
        val visitors: ArrayList<BarEntry> = arrayListOf()

        visitors.add(BarEntry(0f, dataCountry[0].total_vaccinations_per_hundred.toFloat()))
        visitors.add(BarEntry(0f, dataCountry[0].people_vaccinated_per_hundred.toFloat()))
        visitors.add(BarEntry(0f, dataCountry[0].people_fully_vaccinated_per_hundred.toFloat()))

        visitors.add(BarEntry(1f, dataCountry[1].total_vaccinations_per_hundred.toFloat()))
        visitors.add(BarEntry(1f, dataCountry[1].people_vaccinated_per_hundred.toFloat()))
        visitors.add(BarEntry(1f, dataCountry[1].people_fully_vaccinated_per_hundred.toFloat()))

        visitors.add(BarEntry(2f, dataCountry[2].total_vaccinations_per_hundred.toFloat()))
        visitors.add(BarEntry(2f, dataCountry[2].people_vaccinated_per_hundred.toFloat()))
        visitors.add(BarEntry(2f, dataCountry[2].people_fully_vaccinated_per_hundred.toFloat()))

        visitors.add(BarEntry(3f, dataCountry[3].total_vaccinations_per_hundred.toFloat()))
        visitors.add(BarEntry(3f, dataCountry[3].people_vaccinated_per_hundred.toFloat()))
        visitors.add(BarEntry(3f, dataCountry[3].people_fully_vaccinated_per_hundred.toFloat()))

        visitors.add(BarEntry(4f, dataCountry[4].total_vaccinations_per_hundred.toFloat()))
        visitors.add(BarEntry(4f, dataCountry[4].people_vaccinated_per_hundred.toFloat()))
        visitors.add(BarEntry(4f, dataCountry[4].people_fully_vaccinated_per_hundred.toFloat()))


        val barDataSet = BarDataSet(visitors, "Corona Vaccine")
        barDataSet.apply {
            colors = ColorTemplate.MATERIAL_COLORS.toMutableList()
            valueTextColor = Color.BLACK
            valueTextSize = 16f
        }

        val barData = BarData(barDataSet)
        binding!!.barChart.apply {
            setFitBars(true)
            data = barData
            description.text = "Corona Vaccine"
            animateY(2000)
        }
    }

    override fun addCallBack() {
    }

    override fun onClickItem(vaccine: VaccineDetails) {
        val intent = Intent(context?.applicationContext, DetailsData::class.java)
        startActivity(intent)
//        intent.putExtra(Constants.VACCINE, vaccine)
    }

}