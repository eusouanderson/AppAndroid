package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.txt_result)

        val button_convert = findViewById<Button>(R.id.button)

        button_convert.setOnClickListener {

            result.text = "novo texto"
            result.visibility = View.VISIBLE
        }

    }
    private fun converter() {

    }
}

