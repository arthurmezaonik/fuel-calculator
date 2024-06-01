package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class CarConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_consumption)

        // from previous screen
        val fuelValue :Float = intent.getFloatExtra(KEY_RESULT_FUEL_VALUE, 0.0f)

        val nextButton : Button = findViewById(R.id.buttonNext)
        val editTextCarConsumption = findViewById<TextInputEditText>(R.id.editTextCarConsumption)

        nextButton.setOnClickListener {
            val carConsumption:String = editTextCarConsumption.text.toString()

            if(carConsumption.isEmpty()){
                Snackbar.make(
                    nextButton,
                    "Please answer all the fields.",
                    Snackbar.LENGTH_LONG
                ).show()
            } else{
                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_RESULT_FUEL_VALUE, fuelValue)
                intent.putExtra(KEY_RESULT_CAR_CONSUMPTION, carConsumption.toFloat())
                startActivity(intent)
            }
        }
    }
}