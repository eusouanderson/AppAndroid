package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import javax.net.ssl.HttpsURLConnection
import java.net.URL

class ScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_two)
        val text = findViewById<TextView>(R.id.textView)
        val butoon = findViewById<Button>(R.id.button)

        butoon.setOnClickListener {
            Thread {
                val url = URL("https://server-eqbe.onrender.com/api/usuarios")
                val conn = url.openConnection() as HttpsURLConnection

                try {
                    val data = conn.inputStream.bufferedReader().readText()

                    runOnUiThread {
                        text.text = data
                    }
                } finally {
                    conn.disconnect()
                }
            }.start()
        }
    }
}






