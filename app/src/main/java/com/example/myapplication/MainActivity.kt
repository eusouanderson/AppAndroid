package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.content.Intent
import android.net.Uri
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.os.persistableBundleOf


class MainActivity : AppCompatActivity() {

    private var email: String = "dfg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<View>(R.id.container)
        val logo = findViewById<ImageView>(R.id.logo)
        val email = findViewById<TextInputEditText>(R.id.edit_email)
        val password = findViewById<TextInputEditText>(R.id.edit_password)
        val email_cadastro = findViewById<TextInputLayout>(R.id.txt_input_email_CADASTRO)
        val password_cadastro = findViewById<TextInputLayout>(R.id.txt_input_password_CADASTRO)
        val nome_cadastro = findViewById<TextInputLayout>(R.id.txt_input_nome_CADASTRO)
        val botao_login = findViewById<AppCompatButton>(R.id.btlogin)
        val text_cadastro = findViewById<TextView>(R.id.txtTelaCadastro)
        val progress_bar = findViewById<ProgressBar>(R.id.progressBar)
        val botao_cadastro = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val footer = findViewById<View>(R.id.footer)

        val newvalor = 1800

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

        }
    }
    fun login (){
        if (email == "guhfuig"){

            persistableBundleOf()
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









