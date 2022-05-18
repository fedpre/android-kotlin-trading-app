package com.example.tradingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_app)

        val registerBtn: Button = findViewById(R.id.registerBtnReg)

        registerBtn.setOnClickListener {
            // get user input
            val userFullname: EditText = findViewById(R.id.fullnameInput)
            val userEmail: EditText = findViewById(R.id.emailInput)
            val userUsername: EditText = findViewById(R.id.usernameInput)
            val userPassword: EditText = findViewById(R.id.passwordInput)

            // create shared preferences file
            val pref = getSharedPreferences("userDetails", Context.MODE_PRIVATE)
            val editor = pref.edit()
            // save name
            editor.putString("FULLNAME", userFullname.text.toString())
            editor.putString("EMAIL", userEmail.text.toString())
            editor.putString("USERNAME", userUsername.text.toString())
            editor.putString("PASSWORD", userPassword.text.toString())
            editor.putFloat("BALANCE", 0.00F)
            editor.apply()

            val intent = Intent(this, LoginApp::class.java)
            Toast.makeText(this, "User registered correctly. Please login.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}