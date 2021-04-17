package com.example.belajarandroidjetpackpro.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.databinding.ActivityHomeBinding
import com.example.belajarandroidjetpackpro.ui.detail.DetailMovieActivity
import com.example.belajarandroidjetpackpro.ui.favorite.FavoriteActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            val intent = Intent(applicationContext, FavoriteActivity::class.java)
            applicationContext.startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}