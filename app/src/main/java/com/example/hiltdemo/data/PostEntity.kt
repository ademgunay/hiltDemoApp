package com.example.hiltdemo.data

import com.google.gson.annotations.SerializedName

data class PostEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)