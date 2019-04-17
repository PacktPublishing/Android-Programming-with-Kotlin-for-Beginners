package com.gamecodeschool.fragmentslider

import android.os.Bundle
import android.view.View
import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize a list of three fragments
        val fragmentList = ArrayList<Fragment>()

        // Add three new Fragments to the list
        fragmentList.add(SimpleFragment.newInstance("1"))
        fragmentList.add(SimpleFragment.newInstance("2"))
        fragmentList.add(SimpleFragment.newInstance("3"))

        val pageAdapter = SimpleFragmentPagerAdapter(
                supportFragmentManager, fragmentList)

        val pager = findViewById<View>(R.id.pager) as ViewPager
        pager.adapter = pageAdapter

    }

    private inner class SimpleFragmentPagerAdapter
        // A constructor to receive a fragment manager and a List
        (fm: FragmentManager,
        // An ArrayList to hold our fragments
        private val fragments: ArrayList<Fragment>)
        : FragmentPagerAdapter(fm) {

        // Just two methods to override to get the current
        // position of the adapter and the size of the List
        override fun getItem(position: Int): Fragment {
            return this.fragments[position]
        }

        override fun getCount(): Int {
            return this.fragments.size
        }
    }
}
