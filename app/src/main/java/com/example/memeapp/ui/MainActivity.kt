package com.example.memeapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility

import com.example.memeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MYAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewmodel : Vm by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        recyclerView = binding.myRecyclerView
        adapter = MYAdapter(mutableListOf())

        recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
        }


        viewmodel.name.observe(this) { state ->
            updateUI(state)
        }

        viewmodel.loadMeme()



    }

    private fun updateUI(state: MemeUiState) {

        if (state.isLoading == true){
            binding.progressBar.visibility = View.VISIBLE
            binding.myRecyclerView.visibility = View.INVISIBLE
        }else if (state.memes.isNotEmpty()){
            adapter.updatelist(state.memes)
            binding.progressBar.visibility = View.INVISIBLE
            binding.myRecyclerView.visibility = View.VISIBLE
        }else{
            Log.e("Mytag","${state.error}")
        }
    }
}