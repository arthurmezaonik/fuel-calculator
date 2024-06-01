package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initButton = findViewById<Button>(R.id.buttonStart);
        initButton.setOnClickListener{
            val intent = Intent(this, FuelPriceActivity::class.java)
            startActivity(intent)
        }
    }
}