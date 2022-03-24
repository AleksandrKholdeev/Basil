package com.example.basil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basil.fragments.LaunchScreenFragment
import com.example.basil.fragments.RecipeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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