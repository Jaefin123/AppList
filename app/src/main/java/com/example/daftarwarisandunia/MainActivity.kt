package com.example.daftarwarisandunia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftargamesaya.R
import com.example.daftarwarisandunia.ActivityDetail.Companion.Data


class MainActivity : AppCompatActivity() {

    private lateinit var rvTempat: RecyclerView
    private val list = ArrayList<Tempat>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvTempat = findViewById(R.id.daftar_tempat)
        rvTempat.setHasFixedSize(true)

        list.addAll(getListGame())
        showRecyclerList()

        val btn: ImageView = findViewById(R.id.profile_image)
        btn.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, ActivityAbout::class.java)
            startActivity(moveIntent)
        }

    }

    private fun getListGame(): ArrayList<Tempat> {
        val dataName = resources.getStringArray(R.array.data_nama)
        val dataPenerbit = resources.getStringArray(R.array.data_negara)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTempat = ArrayList<Tempat>()
        for (i in dataName.indices) {
            val tempat = Tempat(dataName[i],dataPenerbit[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listTempat.add(tempat)
        }
        return listTempat
    }

    private fun showRecyclerList() {
        rvTempat.layoutManager = LinearLayoutManager(this)
        val listTempatAdapter = TempatListAdapter(list)
        rvTempat.adapter = listTempatAdapter

        listTempatAdapter.setOnItemClickCallback(object : TempatListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tempat) {
                val person = Tempat(
                    data.name,
                    data.negara,
                    data.description,
                    data.photo
                )
                val moveIntent = Intent(this@MainActivity, ActivityDetail::class.java)
                moveIntent.putExtra(Data, person)
                startActivity(moveIntent)
            }
        })

    }

}











