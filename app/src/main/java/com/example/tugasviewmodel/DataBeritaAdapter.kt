package com.example.tugasviewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasviewmodel.databinding.ItemBinding


class DataBeritaAdapter(var dataBerita : MutableList<DataBerita>, val listern : CLicked): RecyclerView.Adapter<DataBeritaAdapter.DataBeritaViewHolder>() {
    inner class DataBeritaViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBeritaViewHolder {
        return DataBeritaViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DataBeritaViewHolder, position: Int) {
        holder.binding.apply {
            tvjudulBerita.text = dataBerita[position].judul
            tvTanggal.text = dataBerita[position].tanggal
            tvJurnalis.text = dataBerita[position].jurnalis
            tvDesc.text = dataBerita[position].judul
            imgBerita.setImageResource(dataBerita[position].img)

            cardSatu.setOnClickListener {
                listern.onClick(dataBerita[position])
            }
        }
    }

    override fun getItemCount(): Int = dataBerita.size


    interface CLicked {
        fun onClick(dataBerita: DataBerita)
    }
    fun dataSatu(datafirst : MutableList<DataBerita>){
        this.dataBerita = datafirst
    }

}






