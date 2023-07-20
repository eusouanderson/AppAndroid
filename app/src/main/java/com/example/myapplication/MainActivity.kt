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

class MainActivity : AppCompatActivity() {

    private lateinit var header: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<View>(R.id.container)
        val logo = findViewById<ImageView>(R.id.logo)
        val email = findViewById<TextInputEditText>(R.id.edit_email)
        val password = findViewById<TextInputEditText>(R.id.edit_password)
        //val email_cadastro = findViewById<TextInputEditText>(R.id.edit_email_CADASTRO)
        val password_cadastro = findViewById<TextInputEditText>(R.id.edit_password_CADASTRO)
        val botao_login = findViewById<AppCompatButton>(R.id.btlogin)
        val text_cadastro = findViewById<TextView>(R.id.txtTelaCadastro)
        val progress_bar = findViewById<ProgressBar>(R.id.progressBar)
        val botao_cadastro = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val footer = findViewById<View>(R.id.footer)
        //val nome_cadastro = findViewById<TextInputEditText>(R.id.edit_nome_CADASTRO)
        val newvalor = 1800

        botao_cadastro.setOnClickListener {
            //container.layoutParams.height = newvalor
            //container.requestLayout()
            //nome_cadastro.visibility = View.VISIBLE
            //email_cadastro.bringToFront()
            //password_cadastro.visibility = View.VISIBLE
        }
    }
}





