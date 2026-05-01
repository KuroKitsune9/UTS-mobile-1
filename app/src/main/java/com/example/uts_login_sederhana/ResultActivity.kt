package com.example.uts_login_sederhana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvHp = findViewById<TextView>(R.id.tvHp)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvSeminar = findViewById<TextView>(R.id.tvSeminar)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        tvNama.text = "Nama: ${intent.getStringExtra("nama")}"
        tvEmail.text = "Email: ${intent.getStringExtra("email")}"
        tvHp.text = "HP: ${intent.getStringExtra("hp")}"
        tvGender.text = "Gender: ${intent.getStringExtra("gender")}"
        tvSeminar.text = "Seminar: ${intent.getStringExtra("seminar")}"

        btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}