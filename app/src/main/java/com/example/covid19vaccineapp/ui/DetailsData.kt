package com.example.covid19vaccineapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19vaccineapp.Utilse.Constants
import com.example.covid19vaccineapp.databinding.DetailsDataBinding
import com.example.covid19vaccineapp.model.VaccineDetails

class DetailsData : AppCompatActivity() {

    val LOG_TAG: String = "DETAILS_DATA"

    lateinit var binding : DetailsDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vaccine = intent.getSerializableExtra(Constants.VACCINE) as VaccineDetails
        vaccine.let {

        }

        setup()
    }

    fun setup() {

    }
}