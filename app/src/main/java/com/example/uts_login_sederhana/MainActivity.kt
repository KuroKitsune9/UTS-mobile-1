package com.example.uts_login_sederhana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("user", MODE_PRIVATE)
        val username = prefs.getString("username", "User")

        val tvUser = findViewById<TextView>(R.id.tvUser)
        tvUser.text = "Selamat datang, $username"

        val btn = findViewById<Button>(R.id.btnDaftar)

        btn.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}