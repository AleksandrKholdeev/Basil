package com.example.basil

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basil.fragments.LaunchScreenFragment
import com.example.basil.fragments.RecipeFragment

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isReloaded = savedInstanceState?.getBoolean("isReloaded", false)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: $isReloaded")

        if (isReloaded == true) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout__activity_main, RecipeFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout__activity_main, LaunchScreenFragment())
                .commit()
            Thread {
                Thread.sleep(2400)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout__activity_main, RecipeFragment())
                    .commit()
            }.start()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putBoolean("isReloaded", true)
    }

}