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
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaProtectionFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaReasonsFragment
import com.example.covid19vaccineapp.fragments.fragmentCoronaVirus.CoronaSyndromeFragment

class CoronaVirusFragment : BaseFragment<FragmentCoronaVirusBinding>() {

    override val LOG_TAG: String = "CORONA_VIRUS_FRAGMENT"

    override val bindingInflater: (LayoutInflater) -> FragmentCoronaVirusBinding = FragmentCoronaVirusBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.apply {
            setupViewPager(coronaViewpager)
            tabs.setupWithViewPager(coronaViewpager)

            tabs.getTabAt(CORONA)!!.setIcon(R.drawable.ic_virus4)
            tabs.getTabAt(CORONA_REASONS)!!.setIcon(R.drawable.ic_virus4)
            tabs.getTabAt(CORONA_SYNDROME)!!.setIcon(R.drawable.ic_virus4)
            tabs.getTabAt(CORONA_PROTECTION)!!.setIcon(R.drawable.ic_virus4)

        }
    }

    override fun setup() {

    }

    override fun addCallBack() {

    }

    private fun setupViewPager(viewPager: ViewPager) {
        viewPager.adapter = fragmentManager?.let {
            Adapter(it).apply {
                addFragment(CoronaFragment())
                addFragment(CoronaReasonsFragment())
                addFragment(CoronaSyndromeFragment())
                addFragment(CoronaProtectionFragment())
            }
        }
    }

    internal class Adapter(
        fragmentManager: FragmentManager
    ) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragments: MutableList<Fragment> = ArrayList()
//        private val titles: MutableList<String> = ArrayList()

        fun addFragment(fragment: Fragment) {  // , title: String
            fragments.add(fragment)
//            titles.add(title)
        }

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size

//        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }
}