package com.twiceyuan.galleryviewpager

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

object GalleryTransformer : ViewPager.PageTransformer {

    private const val scale = 0.5f

    override fun transformPage(view: View, position: Float) {
        val scaleValue = 1 - abs(position) * scale
        view.scaleX = scaleValue
        view.scaleY = scaleValue
        view.alpha = scaleValue
//        view.pivotX = view.width * (1f - position - if (position > 0) 0.75f else -0.75f) * scale
//        view.pivotY = view.height / 2f
        view.elevation = 1f - abs(position)
    }
}
