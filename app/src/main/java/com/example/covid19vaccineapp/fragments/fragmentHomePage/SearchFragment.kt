package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.FragmentSearchBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import java.util.*
import org.eazegraph.lib.models.PieModel
import android.R
import android.graphics.Color
import org.eazegraph.lib.charts.PieChart

class SearchFragment : BaseFragment<FragmentSearchBinding>(){

    override val LOG_TAG: String = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding = FragmentSearchBinding::inflate

    override fun setup() {
        binding!!.apply {
            searchViewCountry.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchSubmit(query!!)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchTextChange(newText!!)
                    return false
                }

            })
        }
    }

    private fun searchSubmit(country: String) {
        binding!!.apply {
            changeVisibility(true)
            if(country.isEmpty() || DataManger.getCountry(country.lowercase(Locale.getDefault()))
                        [country.lowercase(Locale.getDefault())].isNullOrEmpty()) {
                lottieError.visibility = View.VISIBLE
                changeVisibility(false)
            }else {
                setData(country)
                changeVisibility(true)
            }
            lottieSearch.isVisible = false
        }
    }

    private fun searchTextChange(newText: String){
        binding!!.apply {
          lottieError .visibility = View.GONE
            changeVisibility(false)
            lottieSearch.isVisible = true
            pieChart.isVisible = false
        }
    }

    private fun setData(country: String) {
        DataManger.getCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size-1]
            binding!!.apply {
                txtPeopleVaccine.text = data.people_vaccinated.toInt().toString()
                txtPeopleFullyVaccine.text = data.people_fully_vaccinated.toInt().toString()
                txtCountryName.text = data.country
                txtIsoCode.text = data.iso_code
                txtTotalVaccinations.text = data.total_vaccinations.toInt().toString()

                pieChart.addPieSlice(PieModel("total_vaccinations", data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#FF0000")))
                pieChart.addPieSlice(PieModel("people_vaccinated", data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#00FF00")))
                pieChart.addPieSlice(PieModel("people_fully_vaccinated", data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#0000FF")))

                pieChart.startAnimation()
            }
        }
    }

    override fun addCallBack() {
        changeVisibility(false)
    }

    fun changeVisibility(state: Boolean){
        binding!!.apply {
            cardCountry.isVisible = state
            lottieSearch.isVisible = !state
            pieChart.isVisible = state
        }
    }
}