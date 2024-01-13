package com.twiceyuan.galleryviewpager

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

object GalleryTransformer : ViewPager.PageTransformer {

    private const val scale = 0.28f

    override fun transformPage(view: View, position: Float) {
        val scaleValue = 1 - abs(position) * scale
        view.scaleX = scaleValue
        view.scaleY = scaleValue
        view.alpha = scaleValue
        view.elevation = 1f - abs(position)
    }
}
