package com.twiceyuan.galleryviewpager

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
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

        binding.backgroundViewPager.adapter = InfinitePagerAdapter(BackgroundImagePagerAdapter())

        binding.viewPager.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                var hackedEvent: MotionEvent? = null
                event?.let { scopeEvent ->
                    hackedEvent = MotionEvent.obtain(
                        scopeEvent.downTime,
                        scopeEvent.eventTime, scopeEvent.action, scopeEvent.x * 3f,
                        scopeEvent.y, scopeEvent.metaState
                    )
                }
                hackedEvent?.let {
                    binding.backgroundViewPager.onTouchEvent(it)
                }
                return false
            }
        })

        binding.backgroundViewPager.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                var hackedEvent: MotionEvent? = null
                event?.let { scopeEvent ->
                    hackedEvent = MotionEvent.obtain(
                        scopeEvent.downTime,
                        scopeEvent.eventTime, scopeEvent.action, scopeEvent.x / 3f,
                        scopeEvent.y, scopeEvent.metaState
                    )
                }
                hackedEvent?.let {
                    binding.viewPager.onTouchEvent(it)
                }

                return false
            }
        })
    }
}
