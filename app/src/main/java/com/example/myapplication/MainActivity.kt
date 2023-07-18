package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.txt_result)

        val button_convert = findViewById<Button>(R.id.button)

        button_convert.setOnClickListener {
            converter()
        }

    }

    private fun converter() {
        val selectedCurrency = findViewById<RadioGroup>(R.id.radio_group)
        val checked = selectedCurrency.checkedRadioButtonId
           val currency = when (checked) {
                R.id.radio_usd -> "USD"
                R.id.radio_eur -> "EUR"
                else -> "CLP"
            }
            val editField = findViewById<EditText>(R.id.edit_field)
            val value = editField.text.toString()

            if (value.isEmpty())
                return

            result.text = value
            result.visibility = View.VISIBLE
    }
}
