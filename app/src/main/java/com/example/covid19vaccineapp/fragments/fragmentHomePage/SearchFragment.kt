package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import com.example.covid19vaccineapp.Utilse.DataManger
import com.example.covid19vaccineapp.databinding.FragmentSearchBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import java.util.*
import org.eazegraph.lib.models.PieModel
import android.graphics.Color
import com.example.covid19vaccineapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup

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
//        createChip(country[0])
        binding!!.apply {
            changeVisibility(true)
            if(country.isEmpty() || DataManger.searchCountry(country.lowercase(Locale.getDefault()))
                        [country.lowercase(Locale.getDefault())].isNullOrEmpty()) {
                codeError.visibility = View.VISIBLE
                changeVisibility(false)
            }else {
                setData(country)
                changeVisibility(true)
            }
            imgSearch.isVisible = false
            txtDecryptionSearch.isVisible = false
        }
    }

    private fun createChip(firstCharCountry: Char) {
        binding!!.chipGroupCountry.removeAllViews()
        DataManger.getCountries(firstCharCountry).forEach {
            binding!!.chipGroupCountry.addChip(it)
        }
    }

    private fun searchTextChange(newText: String){
        binding!!.apply {
          codeError.visibility = View.GONE
            changeVisibility(false)
            imgSearch.isVisible = true
            txtDecryptionSearch.isVisible = true
            pieChart.isVisible = false
        }
    }

    private fun setData(country: String) {
        DataManger.searchCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size-1]
            binding!!.apply {
                txtPeopleVaccine.text = data.people_vaccinated.toInt().toString()
                txtPeopleFullyVaccine.text = data.people_fully_vaccinated.toInt().toString()
                txtCountryName.text = data.country
                txtIsoCode.text = data.iso_code
                txtTotalVaccinations.text = data.total_vaccinations.toInt().toString()

                pieChart.addPieSlice(PieModel("total_vaccinations",
                    data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#F0987D")))
                pieChart.addPieSlice(PieModel("people_vaccinated",
                    data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#A175F0")))
                pieChart.addPieSlice(PieModel("people_fully_vaccinated",
                    data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#F0E962")))

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
            imgSearch.isVisible = !state
            txtDecryptionSearch.isVisible = !state
            pieChart.isVisible = state
            shapesearchimg.isVisible = state
        }
    }

    fun ChipGroup.addChip(label: String){
        Chip(context).apply {
            id = View.generateViewId()
            text = label
            isClickable = true
            isCheckable = true
            isCheckedIconVisible = false
            isFocusable = true
            binding!!.chipGroupCountry.addView(this)
        }
    }

//    fun ChipGroup.addChip(label: String){
//        Chip(context).let {
//            val chipDraw =
//                ChipDrawable.createFromAttributes(
//                    (activity)!!,
//                    null,
//                    0,
//                    R.style.Widget_MaterialComponents_Chip_Choice
//                )
//            it.setChipDrawable(chipDraw)
//            it.isCheckable = false
//            it.isClickable = false
//            it.iconStartPadding = 2f
//            it.setPadding(60, 20, 60, 20)
//            it.setTextColor(Color.BLACK)
//            it.setChipBackgroundColorResource(R.color.white)
//            it.setOnCloseIconClickListener {
//                binding?.chipGroupCountry?.removeView(it)
//            }
//            it.text = label
//            binding?.chipGroupCountry?.addView(it)
//        }
//    }
}