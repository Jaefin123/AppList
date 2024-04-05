package com.example.daftarwarisandunia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daftargamesaya.R

class TempatListAdapter(private val listTempat: ArrayList<Tempat>) : RecyclerView.Adapter<TempatListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.gambar_tempat)
        val tempatName: TextView = itemView.findViewById(R.id.nama_tempat)
        val lokasi: TextView = itemView.findViewById(R.id.lokasi)
        val Description: TextView = itemView.findViewById(R.id.deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.baris_daftar_tempat, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTempat.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,lokasi, description, photo) = listTempat[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tempatName.text = name
        holder.lokasi.text = lokasi
        holder.Description.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listTempat[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Tempat)
    }
}