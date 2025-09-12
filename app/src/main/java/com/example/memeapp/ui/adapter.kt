package com.example.memeapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memeapp.data.model.MEME
import com.example.memeapp.databinding.MemeBinding
import kotlinx.coroutines.withContext

class MYAdapter(memeList: List<MEME>) : RecyclerView.Adapter<MyViewHolder>(){
    private var memes = memeList



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val binding = MemeBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
       return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.binding.titleMeme.text = memes[position].author
        Glide.with(holder.binding.root)
            .load(memes[position].url)
            .into(holder.binding.imageMeme)
    }

    override fun getItemCount(): Int = memes.size

    fun updatelist(newlist : List<MEME>){
        memes = newlist
        notifyDataSetChanged()
    }

}



class MyViewHolder(val binding: MemeBinding) : RecyclerView.ViewHolder(binding.root)