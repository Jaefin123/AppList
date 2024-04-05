package com.example.daftarwarisandunia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.daftargamesaya.R

class ActivityAbout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.about_activity)

        val btn: ImageView = findViewById(R.id.btn_back_about_tomain)
        btn.setOnClickListener {
            val moveIntent = Intent(this@ActivityAbout, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}