package com.example.uts_pemrogseluler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val namaDosen = etNamaDosen.text.toString()

            if (namaDosen.isNotEmpty()) {
                val intent = Intent(this, PanelActivity::class.java)
                intent.putExtra("NAMA_DOSEN", namaDosen)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.error_empty_data),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}