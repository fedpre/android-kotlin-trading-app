package com.example.tradingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class AccountApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_app)

        val pref: SharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE)
        val storedFullname = pref.getString("FULLNAME", "")
        val storedBalance = pref.getFloat("BALANCE", 0.00F)

        val accountName: TextView = findViewById(R.id.accountName)
        accountName.text = storedFullname

        val balance: TextView = findViewById(R.id.balanceAmount)
        balance.text = storedBalance.toString()

        val depositBtn: Button = findViewById(R.id.depositBtn)
        depositBtn.setOnClickListener {
            val depositInput: EditText = findViewById(R.id.depositInput)
            var storBalance = pref.getFloat("BALANCE", 0.00F)
            storBalance += depositInput.text.toString().toFloat()
            // create shared preferences file
            val editor = pref.edit()
            editor.putFloat("BALANCE", storBalance)
            editor.apply()

            val intent = Intent(this, AccountApp::class.java)
            Toast.makeText(this, "Amount deposited correctly.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}