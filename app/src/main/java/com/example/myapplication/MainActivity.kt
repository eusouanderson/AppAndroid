package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<View>(R.id.container)
        val logo = findViewById<ImageView>(R.id.logo)

        val email = findViewById<TextInputLayout>(R.id.txt_input_email)
        val password = findViewById<TextInputLayout>(R.id.txt_input_password)

        val nome_cadastro = findViewById<TextInputLayout>(R.id.txt_input_nome_CADASTRO)
        val email_cadastro = findViewById<TextInputLayout>(R.id.txt_input_email_CADASTRO)
        val password_cadastro = findViewById<TextInputLayout>(R.id.txt_input_password_CADASTRO)
        val password_confirme_cadastro = findViewById<TextInputLayout>(R.id.txt_input_password_confirme_CADASTRO)

        val botao_login = findViewById<AppCompatButton>(R.id.btlogin)
        val botao_cadastro = findViewById<AppCompatButton>(R.id.btn_cadastrar)

        val text_cadastro = findViewById<TextView>(R.id.txtTelaCadastro)
        val progress_bar = findViewById<ProgressBar>(R.id.progressBar)

        val footer = findViewById<View>(R.id.footer)

        val newvalor = 1800

        //botão login
        botao_login.setOnClickListener {
            val screenTwo = Intent(this,ScreenTwo::class.java)
            startActivity(screenTwo)
        }
        botao_cadastro.setOnClickListener {
            footer.layoutParams.height = newvalor
            footer.requestLayout()
            botao_login.visibility = View.GONE
            botao_cadastro.visibility = View.GONE
            email.visibility = View.GONE
            password.visibility = View.GONE
            nome_cadastro.visibility = View.VISIBLE
            nome_cadastro.bringToFront()
            email_cadastro.visibility = View.VISIBLE
            email_cadastro.bringToFront()
            password_cadastro.visibility = View.VISIBLE
            password_cadastro.bringToFront()
            password_confirme_cadastro.visibility = View.GONE
            password_confirme_cadastro.bringToFront()

        }
    }

    fun openWebsite(view: View) {
        // URL do site
        val websiteUrl = "https://github.com/eusouanderson"

        // Cria um Intent com a ação ACTION_VIEW e a URI da página da web
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))

        // Verifica se existe um aplicativo que pode lidar com a ação (navegador)
        if (intent.resolveActivity(packageManager) != null) {
            // Se existir, inicia o Intent
            startActivity(intent)
        }
    }

}









