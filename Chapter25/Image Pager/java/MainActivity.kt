package com.gamecodeschool.imagepager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.PagerAdapter

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Grab all the images and stuff them in our array
        val images: IntArray = intArrayOf(R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6)

        // get a reference to the ViewPager in the layout
        val viewPager: ViewPager =
                findViewById<View>(R.id.pager) as ViewPager

        // Initialize our adapter
        val adapter: PagerAdapter =
                ImagePagerAdapter(this, images)

        // Binds the Adapter to the ViewPager
        viewPager.adapter = adapter

    }
}
