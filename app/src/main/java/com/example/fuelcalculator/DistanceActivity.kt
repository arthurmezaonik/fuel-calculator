package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        // from previous screen
        val fuelValue :Float = intent.getFloatExtra(KEY_RESULT_FUEL_VALUE, 0.0f)
        val carConsumption:Float = intent.getFloatExtra(KEY_RESULT_CAR_CONSUMPTION, 0.0f)

        val resultButton:Button = findViewById(R.id.buttonResult)
        val editTextDistance = findViewById<TextInputEditText>(R.id.editTextDistance)

        resultButton.setOnClickListener{
            val distance:String = editTextDistance.text.toString()
            if(distance.isEmpty()){
                Snackbar.make(
                    resultButton,
                    "Please answer all the fields.",
                    Snackbar.LENGTH_LONG
                ).show()
            }else{
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_FUEL_VALUE, fuelValue)
                intent.putExtra(KEY_RESULT_CAR_CONSUMPTION, carConsumption)
                intent.putExtra(KEY_RESULT_DISTANCE, distance.toFloat())
                startActivity(intent)
            }
        }
    }
}