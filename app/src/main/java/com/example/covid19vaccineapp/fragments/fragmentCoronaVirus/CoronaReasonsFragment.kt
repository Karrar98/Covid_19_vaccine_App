package com.example.covid19vaccineapp.fragments.fragmentCoronaVirus

import android.view.LayoutInflater
import com.example.covid19vaccineapp.databinding.FragmentCoronaReasonsBinding
import com.example.covid19vaccineapp.fragments.BaseFragment


class CoronaReasonsFragment : BaseFragment<FragmentCoronaReasonsBinding>() {
    override val LOG_TAG: String = "CORONA_REASONS_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentCoronaReasonsBinding =
        FragmentCoronaReasonsBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }


}