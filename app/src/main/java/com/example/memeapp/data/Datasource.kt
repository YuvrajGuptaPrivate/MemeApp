package com.example.memeapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{

   private const val BaseUrl = "https://meme-api.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()

    }

}