package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentSearchBinding
import com.example.covid19vaccineapp.fragments.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(){

    override val LOG_TAG: String = "SEARCH_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding = FragmentSearchBinding::inflate

    override fun setUp() {

    }

    override fun addCallBack() {

    }
}