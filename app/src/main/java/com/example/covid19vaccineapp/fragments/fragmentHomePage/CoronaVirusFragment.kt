package com.example.covid19vaccineapp.fragments.fragmentHomePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.Utilse.Constants.CoronaTabIndex.CORONA
import com.example.covid19vaccineapp.Utilse.Constants.CoronaTabIndex.CORONA_PROTECTION
import com.example.covid19vaccineapp.Utilse.Constants.CoronaTabIndex.CORONA_REASONS
import com.example.covid19vaccineapp.Utilse.Constants.CoronaTabIndex.CORONA_SYNDROME
import com.example.covid19vaccineapp.databinding.FragmentCoronaVirusBinding
import com.example.covid19vaccineapp.fragments.BaseFragment
import com.example.covid19vaccineapp.fragments.CoronaVirusPagerAdapter
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSyndromeFragment

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding = FragmentCoronaVirusBinding::inflate

    private lateinit var coronaVirusPagerAdapter: CoronaVirusPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coronaVirusPagerAdapter = CoronaVirusPagerAdapter(childFragmentManager)
        binding!!.coronaViewpager.adapter = coronaVirusPagerAdapter
    }

    override fun setup() {

    }

    override fun addCallBack() {

    }

//    private fun setupViewPager(viewPager: ViewPager) {
//        viewPager.adapter = fragmentManager?.let {
//            Adapter(it).apply {
//                addFragment(CoronaFragment(), "Corona")
//                addFragment(CoronaReasonsFragment(), "Corona Reasons")
//                addFragment(CoronaSyndromeFragment(), "Corona Syndrome")
//                addFragment(CoronaProtectionFragment(), "Corona Protection")
//            }
//        }
//    }
//
//    internal class Adapter: FragmentPagerAdapter {
//        private val fragments: MutableList<Fragment> = ArrayList()
//        private val titles: MutableList<String> = ArrayList()
//
//        public constructor(supportFragmentManager: FragmentManager)
//                : super(supportFragmentManager)
//
//        fun addFragment(fragment: Fragment, title: String) {  // , title: String
//            fragments.add(fragment)
//            titles.add(title)
//        }
//
//        override fun getItem(position: Int): Fragment = fragments[position]
//
//        override fun getCount(): Int = fragments.size
//
//        override fun getPageTitle(position: Int): CharSequence? = titles[position]
//    }
}