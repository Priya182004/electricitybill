package com.example.electricitybillcalculator // Ensure package name matches your directory structure

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.electricitybillcalculator.R // Ensure correct import for your project

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure your layout file name is correct

        // Find views by ID
        val etUnits = findViewById<EditText>(R.id.et_units)
        val etMobile = findViewById<EditText>(R.id.et_mobile)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        // Set click listener for the button
        btnCalculate.setOnClickListener { // Removed unused parameter
            val units = etUnits.text.toString()
            val mobile = etMobile.text.toString()

            if (units.isEmpty() || mobile.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Calculate the bill
                val unitsConsumed = units.toInt()
                val billAmount = calculateBill(unitsConsumed)

                // Show the bill in a Toast
                Toast.makeText(this, "Bill Amount: ₹$billAmount", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Method to calculate the bill
    private fun calculateBill(units: Int): Double {
        val rate = if (units <= 100) {
            1.5
        } else if (units <= 200) {
            2.0
        } else {
            3.0
        }

        return units * rate
    }
}
