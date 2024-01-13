package com.twiceyuan.galleryviewpager

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.twiceyuan.galleryviewpager.databinding.ActivityMainBinding
import com.twiceyuan.galleryviewpager.infiniteViewPager.InfinitePagerAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.adapter = InfinitePagerAdapter(ImagePagerAdapter())
        binding.viewPager.setPageTransformer(true, GalleryTransformer)

        binding.backgroundViewPager.adapter = InfinitePagerAdapter(ImagePagerAdapter())

        binding.viewPager.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                binding.backgroundViewPager.onTouchEvent(event)
                return false
            }
        })

        binding.backgroundViewPager.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                binding.viewPager.onTouchEvent(event)
                return false
            }
        })

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            private var mScrollState = ViewPager.SCROLL_STATE_IDLE
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                    binding.backgroundViewPager.setCurrentItem(position, false)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                mScrollState = state;
            }
        })

        binding.backgroundViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            private var mScrollState = ViewPager.SCROLL_STATE_IDLE
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                    binding.viewPager.setCurrentItem(position, false)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                mScrollState = state;
            }

        })
    }
}
