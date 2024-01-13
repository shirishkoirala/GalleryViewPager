package com.twiceyuan.galleryviewpager

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter

/**
 * Created by twiceYuan on 9/13/16.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */
class BackgroundImagePagerAdapter : PagerAdapter() {

    private var imgRes = intArrayOf(
        R.drawable.back_to_the_future,
        R.drawable.good_fellas,
        R.drawable.jaws,
        R.drawable.matrix,
        R.drawable.pulp_fiction
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Initialize Views parent - child order
        val imageView = AppCompatImageView(container.context)
        // Modify Views in parent - child order

        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(imgRes[position])
        imageView.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View)
    }

    override fun getCount(): Int {
        return imgRes.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }
}
