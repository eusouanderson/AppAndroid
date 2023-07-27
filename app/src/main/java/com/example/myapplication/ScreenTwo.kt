package com.example.myapplication
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

class ScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_two)
        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Thread {
                val url = URL("https://server-eqbe.onrender.com/api/usuarios")
                val conn = url.openConnection() as HttpsURLConnection
                val nome_cadastro = findViewById<TextInputLayout>(R.id.txt_input_nome_CADASTRO)


                try {
                    val data = conn.inputStream.bufferedReader().readText()

                    val gson = Gson()
                    val usersList = gson.fromJson(data, Array<User>::class.java)

                    for (user in usersList) {
                        val name = user.name
                        val email = user.email
                        val password = user.password

                        runOnUiThread {
                            text.text = "Ola $name, $email, $password, $nome_cadastro"
                        }
                    }

                } finally {
                    conn.disconnect()
                }
            }.start()
        }
    }
}

data class User(val name: String, val email: String, val password: String)






