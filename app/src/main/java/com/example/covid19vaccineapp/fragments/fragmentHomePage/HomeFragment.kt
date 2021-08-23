package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.graphics.Color
import android.view.LayoutInflater
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS
import org.eazegraph.lib.models.PieModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        setData(DataManger.getCountryIndex())
        binding!!.apply {
            nextCountry.setOnClickListener {
                DataManger.nextCountry()
                setData(DataManger.getCountryIndex())
            }
            previousCountry.setOnClickListener {
                DataManger.previousCountry()
                setData(DataManger.getCountryIndex())
            }
        }

    }

    override fun addCallBack() {
    }

    private fun setData(countryIndex: Int) {
        val data = DataManger.getDataCountry(countryIndex)
        binding!!.apply {
            txtCountryName.text = data.country
            txtIsoCode.text = data.iso_code
            peopleVaccine.text = data.people_vaccinated_per_hundred.toString() + " %"
            peopleFullyVaccine.text = data.people_fully_vaccinated_per_hundred.toString() + " %"
            peopleTotalVaccine.text = data.total_vaccinations_per_hundred.toString() + " %"

            pieChart.addPieSlice(PieModel("total_vaccinations",
                data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#0c422d")))
            pieChart.addPieSlice(PieModel("people_vaccinated",
                data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#10a870")))
            pieChart.addPieSlice(PieModel("people_fully_vaccinated",
                data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#76cba8")))

            pieChart.startAnimation()

//                var visitors: ArrayList<BarEntry> = arrayListOf()
//                visitors.add(BarEntry(0f, data.total_vaccinations_per_hundred.toFloat()))
//                visitors.add(BarEntry(1f, data.people_vaccinated_per_hundred.toFloat()))
//                visitors.add(BarEntry(2f, data.people_fully_vaccinated_per_hundred.toFloat()))
//
//                var barDataSet = BarDataSet(visitors, "Corona Vaccine")
//                barDataSet.colors = ColorTemplate.MATERIAL_COLORS.toMutableList()
//                barDataSet.valueTextColor = Color.BLACK
//                barDataSet.valueTextSize = 16f
//
//                var barData = BarData(barDataSet)
//                barChartVaccine.setFitBars(true)
//                barChartVaccine.data = barData
//                barChartVaccine.description.text = "Corona Vaccine"
//                barChartVaccine.animateY(2000)
                
//                pieChart.addPieSlice(PieModel("total_vaccinations", data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#FF0000")))
//                pieChart.addPieSlice(PieModel("people_vaccinated", data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#00FF00")))
//                pieChart.addPieSlice(PieModel("people_fully_vaccinated", data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#0000FF")))
//
//                pieChart.startAnimation()
        }
    }
}