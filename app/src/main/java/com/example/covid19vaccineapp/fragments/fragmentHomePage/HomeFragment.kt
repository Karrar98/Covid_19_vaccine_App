package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.graphics.Color
import android.view.LayoutInflater
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import org.eazegraph.lib.models.PieModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
    }

    override fun addCallBack() {
    }

    private fun setData(country: String) {
        DataManger.getCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size-1]
            binding!!.apply {
//                txtPeopleVaccine.text = data.people_vaccinated.toInt().toString()
//                txtPeopleFullyVaccine.text = data.people_fully_vaccinated.toInt().toString()
//                txtCountryName.text = data.country
//                txtIsoCode.text = data.iso_code
//                txtTotalVaccinations.text = data.total_vaccinations.toInt().toString()
//
//                pieChart.addPieSlice(PieModel("total_vaccinations", data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#FF0000")))
//                pieChart.addPieSlice(PieModel("people_vaccinated", data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#00FF00")))
//                pieChart.addPieSlice(PieModel("people_fully_vaccinated", data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#0000FF")))
//
//                pieChart.startAnimation()
            }
        }
    }
}