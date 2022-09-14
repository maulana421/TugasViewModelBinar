package com.example.tugasviewmodel

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataBeritaAdapter: DataBeritaAdapter
    private lateinit var dataBeritaViewModel: DataBeritaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dataBeritaViewModel = ViewModelProvider(this)[DataBeritaViewModel::class.java]
        dataBeritaViewModel.beritaList.observe(this){
            dataBeritaAdapter.dataSatu(it.toMutableList())
        }
        dataBeritaViewModel.getberitaList()
        showRecycler()
    }
    private fun showRecycler(){
        dataBeritaAdapter = DataBeritaAdapter(mutableListOf(),object : DataBeritaAdapter.CLicked{
            override fun onClick(dataBerita: DataBerita) {
                startActivity(Intent(this@MainActivity,DetailActivity::class.java).also {
                    it.putExtra("berita",dataBerita)
                })
            }

        })
        binding.rvmain.apply {
            adapter = dataBeritaAdapter
            layoutManager = if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                GridLayoutManager(this@MainActivity,3)
            }else{
                LinearLayoutManager(this@MainActivity)
            }
        }


    }
}