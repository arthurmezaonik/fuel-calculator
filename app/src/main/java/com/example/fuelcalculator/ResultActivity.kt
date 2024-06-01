package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val  KEY_RESULT_FUEL_VALUE = "ResultActivity.FUEL_VALUE"
const val  KEY_RESULT_CAR_CONSUMPTION = "ResultActivity.CAR_CONSUMPTION"
const val  KEY_RESULT_DISTANCE = "ResultActivity.DISTANCE"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // from previous screen
        val fuelValue:Float = intent.getFloatExtra(KEY_RESULT_FUEL_VALUE, 0.0f)
        val carConsumption:Float = intent.getFloatExtra(KEY_RESULT_CAR_CONSUMPTION, 0.0f)
        val distance:Float = intent.getFloatExtra(KEY_RESULT_DISTANCE, 0.0f)

        // calc result
        val totalLitre:Float = distance / carConsumption
        val totalCost:Float = totalLitre * fuelValue

        // views
        val restartButton: Button = findViewById(R.id.buttonRestart)
        val textViewResult : TextView = findViewById(R.id.textViewResult)
        val textViewFuelPrice = findViewById<TextView>(R.id.textViewFuelPrice)
        val textViewCarConsumption:TextView = findViewById(R.id.textViewCarConsumption)
        val textViewDistance:TextView = findViewById(R.id.textViewDistance)

        textViewResult.text = String.format("$%.2f", totalCost)
        textViewFuelPrice.text = "$$fuelValue l"
        textViewCarConsumption.text = "$carConsumption km/l"
        textViewDistance.text = "$distance km"

        restartButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}