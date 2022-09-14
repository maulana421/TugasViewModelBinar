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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withnavcom.Adapter.DataBeritaAdapter
import com.example.withnavcom.Model.DataBerita
import com.example.withnavcom.Model.DataBeritaViewModel
import com.example.withnavcom.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var dataBeritaAdapter: DataBeritaAdapter
    private lateinit var dataBeritaViewModel: DataBeritaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        dataBeritaViewModel = ViewModelProvider(this)[DataBeritaViewModel::class.java]
        // Inflate the layout for this fragment
        return binding.root
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecycler()
        dataBeritaViewModel.getberitaList()
        dataBeritaViewModel.beritaList.observe(requireActivity()){
            dataBeritaAdapter.dataSatu(it as MutableList<DataBerita>)
        }


    }

    private fun showRecycler(){
        dataBeritaAdapter = DataBeritaAdapter(mutableListOf(),object : DataBeritaAdapter.CLicked{
            override fun onClick(dataBerita: DataBerita) {
                val navargs = HomeFragmentDirections.actionHomeFragmentToDetailBeritaFragment(
                    dataBerita
                )
                findNavController().navigate(navargs)
            }

        })
        binding.rv.apply {
            adapter = dataBeritaAdapter
            layoutManager = if(context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                GridLayoutManager(activity,3)
            }else{
                LinearLayoutManager(activity)
            }
        }
    }


}