package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.send_button)


        button.setOnClickListener {
            login()
        }
    }
    private fun login(){
        val logo = findViewById<ImageView>(R.id.logo)
        val email = findViewById<TextView>(R.id.entry_email)
        val password = findViewById<TextView>(R.id.entry_password)
        val valueEmail = email.text.toString()
        val valuePasswod = password.text.toString()
        if (valueEmail == "eusouanderson"){
            logo.visibility = View.GONE
        }
        else if (valuePasswod == "123"){
            logo.visibility = View.GONE
        }
    }
    private fun clear(){

        val logo = findViewById<ImageView>(R.id.logo)
        val email = findViewById<TextView>(R.id.entry_email)
        val password = findViewById<TextView>(R.id.entry_password)
        logo.visibility = View.GONE
        email.visibility = View.GONE
        password.visibility = View.GONE

    }
}



