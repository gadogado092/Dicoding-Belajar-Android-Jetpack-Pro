package com.example.belajarandroidjetpackpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajarandroidjetpackpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mLiveDataTimerModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mLiveDataTimerModel = ViewModelProvider(this)[MainViewModel::class.java]
        subscribe()
    }

    private fun subscribe(){
        val elapsedTimeObserver = Observer<Long?>{ aLong ->
            val newText = this@MainActivity.resources.getString(R.string.seconds, aLong)
            activityMainBinding.timerTextview.text = newText
        }

        mLiveDataTimerModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}