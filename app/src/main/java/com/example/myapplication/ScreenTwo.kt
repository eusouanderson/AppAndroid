package com.example.myapplication
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import org.json.JSONObject
import javax.net.ssl.HttpsURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ScreenTwo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_two)
        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        // Recebe o valor do nome do usuário da intent
        val nomeUsuario = intent.getStringExtra("nome_usuario")

        text.text = "Olá, $nomeUsuario!"

    }
}








