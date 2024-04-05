package com.example.daftarwarisandunia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.daftargamesaya.R

class ActivityDetail : AppCompatActivity() {

    companion object {
        const val Data = "extra_person"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val btn: ImageView = findViewById(R.id.btn_back_detail_tomain)
        btn.setOnClickListener {
            val moveIntent = Intent(this@ActivityDetail, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        val nama: TextView = findViewById(R.id.nama_tempat)
        val lokasi: TextView = findViewById(R.id.detail_lokasi)
        val desk: TextView = findViewById(R.id.detail_desk)
        val gambar: ImageView = findViewById(R.id.gambar_tempat)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Tempat>(Data, Tempat::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Tempat>(Data)
        }

        if (person != null){
            nama.text = person.name
            lokasi.text = "By: ${person.negara}"
            desk.text = person.description
            gambar.setImageResource(person.photo)
        }

    }

}