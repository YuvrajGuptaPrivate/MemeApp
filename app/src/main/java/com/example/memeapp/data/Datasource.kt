package com.example.memeapp.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{

   private const val BaseUrl = "https:/meme-api.com/"


    private  val loggingInterceptor = HttpLoggingInterceptor().apply {
        level  = HttpLoggingInterceptor.Level.BODY
    }


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()





    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BaseUrl)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()

    }

}