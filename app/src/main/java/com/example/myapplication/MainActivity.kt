package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONException
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var viewsToHide: List<View> = listOf()
    private var viewsToSee: List<View> = listOf()
    private val usersMap = HashMap<String, String>()
    private lateinit var progressBar: ProgressBar


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchUsersData()
        startRegister()
        findViewById<View>(R.id.container)
        findViewById<ImageView>(R.id.logo)

        val email = findViewById<TextInputLayout>(R.id.txt_input_email)
        val password = findViewById<TextInputLayout>(R.id.txt_input_password)
        val nome_cadastro = findViewById<TextInputLayout>(R.id.txt_input_nome_CADASTRO)
        val email_cadastro = findViewById<TextInputLayout>(R.id.txt_input_email_CADASTRO)
        val password_cadastro = findViewById<TextInputLayout>(R.id.txt_input_password_CADASTRO)
        val password_confirme_cadastro =findViewById<TextInputLayout>(R.id.txt_input_password_confirme_CADASTRO)
        val botao_login = findViewById<AppCompatButton>(R.id.btlogin)
        val botao_ir_cadastro = findViewById<AppCompatButton>(R.id.btn_ir_cadastrar)
        val botao_cadastrar = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val text_cadastro = findViewById<TextView>(R.id.txtTelaCadastro)
        progressBar = findViewById(R.id.progressBar)
        val footer = findViewById<View>(R.id.footer)
        val git = findViewById<ImageView>(R.id.imageView2)
        val newValue = 1800

        //Screen Two
        val name = findViewById<TextView>(R.id.name)


        viewsToHide = listOf(email, password, botao_ir_cadastro, botao_login, text_cadastro, git)
        viewsToSee = listOf(
            nome_cadastro,
            email_cadastro,
            password_cadastro,
            password_confirme_cadastro,
            botao_cadastrar
        )

        //botão login
        botao_login.setOnClickListener {
            /*val screenTwo = Intent(this,ScreenTwo::class.java)
            startActivity(screenTwo)*/
        }
        botao_ir_cadastro.setOnClickListener {
            hideViews()
            showViews()
            // Modificar a altura do footer (exemplo: 200dp)
            footer.layoutParams.height = newValue

            // Mudar o background do footer (exemplo: cor sólida)
            footer.setBackgroundResource(R.color.blue)

            footer.requestLayout()
        }
    }

    private fun hideViews() {
        for (view in viewsToHide) {
            view.visibility = View.GONE
        }
    }

    private fun showViews() {
        for (view in viewsToSee) {
            view.visibility = View.VISIBLE
        }
    }

    private fun fetchUsersData() {
        val url = "https://server-eqbe.onrender.com/api/usuarios"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    for (i in 0 until response.length()) {
                        val jsonObject = response.getJSONObject(i)
                        val email = jsonObject.getString("email")
                        val password = jsonObject.getString("password")
                        val name = jsonObject.getString("name")

                        usersMap[email] = password
                    }


                    setupLoginButton()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
                error.printStackTrace()
                Toast.makeText(this, "Falha ao obter os dados do usuário.", Toast.LENGTH_SHORT)
                    .show()
            })

        Volley.newRequestQueue(this).add(request)
    }

    private fun setupLoginButton() {
        val buttonLogin = findViewById<AppCompatButton>(R.id.btlogin)

        buttonLogin.setOnClickListener {
            val email = findViewById<TextInputLayout>(R.id.txt_input_email).editText?.text.toString()
            val password = findViewById<TextInputLayout>(R.id.txt_input_password).editText?.text.toString()

            if (isValidCredentials(email, password)) {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Login bem-sucedido", Toast.LENGTH_LONG).show()
                val screenTwo = Intent(this, ScreenTwo::class.java)
                startActivity(screenTwo)
            } else {
                Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        val storedPassword = usersMap[email]
        return storedPassword != null && storedPassword == password
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


    private fun startRegister() {
        val nomeCadastro = findViewById<TextInputLayout>(R.id.txt_input_nome_CADASTRO)
        val emailCadastro = findViewById<TextInputLayout>(R.id.txt_input_email_CADASTRO)
        val passwordCadastro = findViewById<TextInputLayout>(R.id.txt_input_password_CADASTRO)
        val passwordConfirmeCadastro = findViewById<TextInputLayout>(R.id.txt_input_password_confirme_CADASTRO)
        val salvarButton = findViewById<Button>(R.id.btn_cadastrar)

        salvarButton.setOnClickListener {


            val nome = nomeCadastro.editText?.text.toString()
            val email = emailCadastro.editText?.text.toString()
            val password = passwordCadastro.editText?.text.toString()
            val passwordConfirme = passwordConfirmeCadastro.editText?.text.toString()

            if (nome.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password == passwordConfirme) {
                val jsonObject = JSONObject()
                jsonObject.put("name", nome)
                jsonObject.put("email", email)
                jsonObject.put("password", password)

                // Chame a função para enviar os dados para a URL
                sendJsonData(jsonObject)
            }
            if (password != passwordConfirme) {
                Toast.makeText(
                    this@MainActivity,
                    "As senhas não coincidem!",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (nome == null){
                Toast.makeText(
                    this@MainActivity,
                    "Preencha corretamente todos os campos ",
                    Toast.LENGTH_LONG
                ).show()

            }
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun sendJsonData(jsonObject: JSONObject) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL("https://server-eqbe.onrender.com/api/usuarios/adicionar")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json")
                connection.doOutput = true

                val outputStream = OutputStreamWriter(connection.outputStream)
                outputStream.write(jsonObject.toString())
                outputStream.flush()
                outputStream.close()

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Exibe uma mensagem de sucesso na thread principal
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "Cadastro efetuado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    // Exibe uma mensagem de erro na thread principal
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "Ocorreu um erro no envio",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                connection.disconnect()
            } catch (e: Exception) {
                // Trata a exceção, se necessário
                e.printStackTrace()
            }

        }
    }
}







