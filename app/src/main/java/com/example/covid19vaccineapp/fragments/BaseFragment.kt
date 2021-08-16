package com.example.covid19vaccineapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment(){

    abstract val LOG_TAG : String
    abstract val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> VB
    private lateinit var _binding : VB
    protected val binding
    get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return _binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
        addCallBack()
    }

    abstract fun setUp()

    abstract fun addCallBack()

    protected fun log(value : String) = Log.d(LOG_TAG, value)
}