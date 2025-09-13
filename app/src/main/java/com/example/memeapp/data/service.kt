package com.example.memeapp.data

import com.example.memeapp.data.model.ApiResponse
import retrofit2.http.GET

interface MemeFromInternet{

    @GET("gimme/10")
    suspend fun getMeme(): ApiResponse
}
