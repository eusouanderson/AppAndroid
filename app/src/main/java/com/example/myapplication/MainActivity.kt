package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputLayout
import android.content.Intent
import android.net.Uri
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var viewsToHide: List<View> = listOf()
    private var viewsToSee: List<View> = listOf()

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
        val botao_ir_cadastro = findViewById<AppCompatButton>(R.id.btn_ir_cadastrar)
        val botao_cadastrar = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val text_cadastro = findViewById<TextView>(R.id.txtTelaCadastro)
        val progress_bar = findViewById<ProgressBar>(R.id.progressBar)
        val footer = findViewById<View>(R.id.footer)
        val git = findViewById<ImageView>(R.id.imageView2)
        val newValue = 1800

        viewsToHide = listOf(email, password, botao_ir_cadastro, botao_login, text_cadastro, git)
        viewsToSee = listOf(nome_cadastro, email_cadastro, password_cadastro, password_confirme_cadastro, botao_cadastrar)

        //botão login
        botao_login.setOnClickListener {
            val screenTwo = Intent(this,ScreenTwo::class.java)
            startActivity(screenTwo)
        }
        botao_ir_cadastro.setOnClickListener {
            hideViews()
            showViews()
            footer.layoutParams.height = newValue
            footer.requestLayout()
        }

        botao_cadastrar.setOnClickListener{
            register()
        }
    }
    private fun hideViews() {
        for (view in viewsToHide) {
            view.visibility = View.GONE
        }
    }
    private fun showViews(){
        for (view in viewsToSee){
            view.visibility = View.VISIBLE
        }
    }
    private fun register(){
        val botao_cadastrar = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val password_cadastro = findViewById<EditText>(R.id.edit_password_cadastro)
        val confirme_password = findViewById<EditText>(R.id.edit_password_confirme)
        val value_password = password_cadastro.text.toString()
        val conf_password = confirme_password.text.toString()


        if (value_password == conf_password) {
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        } else {
            Toast.makeText(this, "Senhas não coincidem!", Toast.LENGTH_LONG).show()
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








