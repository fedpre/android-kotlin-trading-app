package com.example.tradingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tradingapp.model.AppDatabase

/*
* TODO: Read from the database to log the user in
 */

class LoginApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_app)

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, AccountApp::class.java)
            val usernameInput: TextView = findViewById(R.id.usernameInput)
            val passwordInput: TextView = findViewById(R.id.passwordInput)

            val pref = getSharedPreferences("userDetails", Context.MODE_PRIVATE)
            val storedUsername = pref.getString("USERNAME", "")
            val storedPassword = pref.getString("PASSWORD", "")

            startActivity(intent)
        }

        val registerBtn: Button = findViewById(R.id.registerBtn)
        registerBtn.setOnClickListener {
            val intent = Intent(this, RegisterApp::class.java)
            startActivity(intent)
        }
    }
}