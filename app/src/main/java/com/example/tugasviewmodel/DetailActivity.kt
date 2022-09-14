package com.example.tugasviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasviewmodel.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showBerita()
    }

    private fun showBerita(){
        val berita = intent.getSerializableExtra("berita") as DataBerita
        binding.apply {
            tvjudulBerita.text = berita.judul
            tvtanggalBerita.text = berita.tanggal
            tvjurnalisBerita.text = berita.jurnalis
            tvdeskripsiBerita.text = berita.deskripsi
        }
    }
}