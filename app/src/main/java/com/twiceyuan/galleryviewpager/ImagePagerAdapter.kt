package com.twiceyuan.galleryviewpager

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter

/**
 * Created by twiceYuan on 9/13/16.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */
class ImagePagerAdapter : PagerAdapter() {

    private var imgRes = intArrayOf(
        R.drawable.img_wallhaven_426244,
        R.drawable.img_wallhaven_431231,
        R.drawable.img_wallhaven_432740,
        R.drawable.img_wallhaven_426244,
        R.drawable.img_wallhaven_431231,
        R.drawable.img_wallhaven_432740,
        R.drawable.img_wallhaven_426244,
        R.drawable.img_wallhaven_431231,
        R.drawable.img_wallhaven_432740
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Initialize Views parent - child order
        val cardView = CardView(container.context)
        val relativeLayout = RelativeLayout(container.context)
        val imageView = AppCompatImageView(container.context)
        // Modify Views in parent - child order
        cardView.radius = container.context.resources.getDimension(R.dimen.card_radius)
        cardView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        relativeLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(imgRes[position])
        imageView.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        // Create View Hierarchy child - parent
        relativeLayout.addView(imageView)
        cardView.addView(relativeLayout)
        container.addView(cardView)
        return cardView
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
