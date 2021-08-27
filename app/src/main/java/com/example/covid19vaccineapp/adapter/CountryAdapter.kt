package com.example.covid19vaccineapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.CountryInteractionListener
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ItemCountryBinding
import com.example.covid19vaccineapp.model.VaccineDetails

class CountryAdapter(private val list: MutableList<VaccineDetails>, private val listener: CountryInteractionListener) :
    RecyclerView.Adapter<CountryAdapter.CountryHolderView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryHolderView(view)
    }

    override fun onBindViewHolder(holder: CountryHolderView, position: Int) {
        val currentCountry = list[position]
        holder.binding.apply {
            txtCountryName.text = currentCountry.country
            txtIsoCode.text = currentCountry.iso_code
            txtPeopleVaccine.text = currentCountry.people_vaccinated.toInt().toString()
            txtPeopleFullyVaccine.text = currentCountry.people_fully_vaccinated.toInt().toString()
            txtTotalVaccine.text = currentCountry.total_vaccinations.toInt().toString()
            txtLastDateVaccine.text = currentCountry.date
            root.setOnClickListener { listener.onClickItem(currentCountry) }
        }
    }

    override fun getItemCount() = list.size

    class CountryHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemCountryBinding.bind(itemView)
    }
}

