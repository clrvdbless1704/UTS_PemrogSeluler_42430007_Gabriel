package com.example.uts_pemrogseluler

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etJumlah = findViewById<EditText>(R.id.etJumlahMahasiswa)
        val etNilai = findViewById<EditText>(R.id.etRataNilai)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val layoutMahasiswa = findViewById<LinearLayout>(R.id.layoutMahasiswa)

        val namaDosen = intent.getStringExtra("NAMA_DOSEN") ?: ""

        tvSapaan.text = getString(R.string.welcome_dosen, namaDosen)

        btnProses.setOnClickListener {

            val jumlahStr = etJumlah.text.toString()
            val nilaiStr = etNilai.text.toString()

            if (jumlahStr.isNotEmpty() && nilaiStr.isNotEmpty()) {

                val jumlahMahasiswa = jumlahStr.toInt()
                val rataNilai = nilaiStr.toInt()

                val statusKelas = if (rataNilai >= 80) {
                    "Sangat Baik"
                } else if (rataNilai >= 60) {
                    "Cukup"
                } else {
                    "Kurang"
                }

                tvStatus.text = getString(R.string.status_kelas, statusKelas)

                // Hapus input sebelumnya
                layoutMahasiswa.removeAllViews()

                // Membuat input nama mahasiswa sesuai jumlah
                for (i in 1..jumlahMahasiswa) {
                    val inputNama = EditText(this)
                    // Note: Ideally, "Nama Mahasiswa" should also be a string resource
                    inputNama.hint = "Nama Mahasiswa $i"
                    inputNama.textSize = 16f
                    inputNama.setPadding(20, 20, 20, 20)
                    layoutMahasiswa.addView(inputNama)
                }

            } else {
                Toast.makeText(this, getString(R.string.error_empty_data), Toast.LENGTH_SHORT).show()
            }
        }
    }
}