package com.twiceyuan.galleryviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }
}
