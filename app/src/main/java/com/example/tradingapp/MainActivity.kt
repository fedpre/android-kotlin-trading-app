package com.example.tradingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.example.tradingapp.model.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedBtn: Button = findViewById(R.id.getStarted)
        getStartedBtn.setOnClickListener {
            val intent = Intent(this, LoginApp::class.java)
            startActivity(intent)
        }
    }
}