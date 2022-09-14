package com.example.withnavcom

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withnavcom.Adapter.DataBeritaAdapter
import com.example.withnavcom.Model.DataBerita
import com.example.withnavcom.Model.DataBeritaViewModel
import com.example.withnavcom.databinding.FragmentDetailBeritaBinding
import com.example.withnavcom.databinding.FragmentHomeBinding


class DetailBeritaFragment : Fragment() {

    private lateinit var binding: FragmentDetailBeritaBinding
    private val navargs by navArgs<DetailBeritaFragmentArgs>()
    private lateinit var dataBeritaAdapter: DataBeritaAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBeritaBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBerita()

    }
    private fun showBerita(){
        binding.apply {
            tvjudulBerita.text = navargs.dataper.judul
            tvtanggalBerita.text = navargs.dataper.tanggal
            tvjurnalisBerita.text = navargs.dataper.jurnalis
            avatar.setImageResource(R.drawable.berita_saham)
            tvdeskripsiBerita.text = navargs.dataper.deskripsi
        }
    }




}