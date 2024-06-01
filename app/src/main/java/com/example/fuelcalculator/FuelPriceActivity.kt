package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class FuelPriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_price)

        val nextButton = findViewById<Button>(R.id.buttonNext)
        val editTextFuelPrice = findViewById<TextInputEditText>(R.id.editTextFuelPrice)

        nextButton.setOnClickListener{
            val fuelPrice:String = editTextFuelPrice.text.toString()

            if(fuelPrice.isEmpty()){
                Snackbar.make(
                    nextButton,
                    "Please answer all the fields.",
                    Snackbar.LENGTH_LONG
                ).show()
            }else{
                val intent = Intent(this, CarConsumptionActivity::class.java)
                intent.putExtra(KEY_RESULT_FUEL_VALUE, fuelPrice.toFloat())
                startActivity(intent)
            }
        }
    }
}