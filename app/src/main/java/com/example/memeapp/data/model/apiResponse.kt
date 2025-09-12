package com.example.memeapp.data.model

data class ApiResponse(
    val status: String,
    val memes: List<MEME>,
    val message: String
)