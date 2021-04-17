package com.example.belajarandroidjetpackpro.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroidjetpackpro.databinding.ActivityFavoriteBinding


class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        setSupportActionBar(activityFavoriteBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityFavoriteBinding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val sectionsPagerFavoriteAdapter = SectionsPagerFavoriteAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = sectionsPagerFavoriteAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)
        supportActionBar?.elevation = 0f
    }
}