package com.example.tradingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tradingapp.model.AppDatabase

class LoginApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_app)

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intentAccount = Intent(this, AccountApp::class.java)
            val usernameInput: TextView = findViewById(R.id.usernameInput)
            val passwordInput: TextView = findViewById(R.id.passwordInput)

            val pref = getSharedPreferences("userDetails", Context.MODE_PRIVATE)
            val storedUsername = pref.getString("USERNAME", "")
            val storedPassword = pref.getString("PASSWORD", "")

            if (usernameInput.text.toString() == storedUsername || passwordInput.text.toString() == storedPassword) {
                startActivity(intentAccount)
            } else {
                Toast.makeText(this, "Username or password incorrect. Please try again.", Toast.LENGTH_SHORT).show()
                usernameInput.text = ""
                passwordInput.text = ""
            }
        }

        val registerBtn: Button = findViewById(R.id.registerBtn)
        registerBtn.setOnClickListener {
            val intent = Intent(this, RegisterApp::class.java)
            startActivity(intent)
        }
    }
}