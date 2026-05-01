package com.example.uts_login_sederhana

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {

    lateinit var etNama: EditText
    lateinit var etEmail: EditText
    lateinit var etHp: EditText
    lateinit var rgGender: RadioGroup
    lateinit var spSeminar: Spinner
    lateinit var cbSetuju: CheckBox
    lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etHp = findViewById(R.id.etHp)
        rgGender = findViewById(R.id.rgGender)
        spSeminar = findViewById(R.id.spSeminar)
        cbSetuju = findViewById(R.id.cbSetuju)
        btnSubmit = findViewById(R.id.btnSubmit)

        val seminarList = listOf(
            "AI & Machine Learning",
            "Cyber Security",
            "Web Development",
            "Mobile Development",
            "Data Science"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, seminarList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSeminar.adapter = adapter

        // VALIDASI REALTIME
        etNama.addTextChangedListener(simpleWatcher { s ->
            etNama.error = if (s.isEmpty()) "Nama tidak boleh kosong" else null
        })

        etEmail.addTextChangedListener(simpleWatcher { s ->
            etEmail.error = if (!s.contains("@")) "Email tidak valid" else null
        })

        etHp.addTextChangedListener(simpleWatcher { s ->
            etHp.error = if (!s.matches(Regex("^08[0-9]{8,11}$"))) "HP tidak valid" else null
        })

        btnSubmit.setOnClickListener {
            if (validasi()) tampilDialog()
        }
    }

    fun simpleWatcher(onChange: (String) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onChange(s.toString())
            }
        }
    }

    fun validasi(): Boolean {
        val nama = etNama.text.toString()
        val email = etEmail.text.toString()
        val hp = etHp.text.toString()

        if (nama.isEmpty()) return etNama.apply { error = "Wajib diisi" } == null
        if (!email.contains("@")) return etEmail.apply { error = "Email salah" } == null
        if (!hp.matches(Regex("^08[0-9]{8,11}$"))) return etHp.apply { error = "HP salah" } == null

        if (rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih gender", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!cbSetuju.isChecked) {
            Toast.makeText(this, "Harus menyetujui", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun tampilDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah data sudah benar?")
            .setPositiveButton("Ya") { _, _ -> kirimData() }
            .setNegativeButton("Tidak", null)
            .show()
    }

    fun kirimData() {
        val gender = if (rgGender.checkedRadioButtonId == R.id.rbLaki) "Laki-laki" else "Perempuan"

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("nama", etNama.text.toString())
        intent.putExtra("email", etEmail.text.toString())
        intent.putExtra("hp", etHp.text.toString())
        intent.putExtra("gender", gender)
        intent.putExtra("seminar", spSeminar.selectedItem.toString())

        startActivity(intent)
    }
}