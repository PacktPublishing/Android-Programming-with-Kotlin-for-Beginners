package com.gamecodeschool.imagepager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout

import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class ImagePagerAdapter(
        var context: Context,
        private var images: IntArray)
        : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(
            container: ViewGroup,
            position: Int)
            : View {

        val image: ImageView
        val inflater: LayoutInflater =
                context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE)
                        as LayoutInflater

        val itemView =
                inflater.inflate(
                        R.layout.pager_item, container,
                        false)

        // get reference to imageView in pager_item layout
        image = itemView.findViewById<View>(R.id.imageView) as ImageView

        // Set an image to the ImageView
        image.setImageResource(images[position])

        // Add pager_item layout as the current page to the ViewPager
        (container as ViewPager).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup,
                             position: Int,
                             `object`: Any) {

        // Remove pager_item layout from ViewPager
        (container as ViewPager).removeView(`object` as RelativeLayout)
    }
}