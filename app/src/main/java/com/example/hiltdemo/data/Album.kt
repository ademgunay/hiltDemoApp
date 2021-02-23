package com.example.hiltdemo.data

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id") val id: String? = null,
    @SerializedName("title") val title: String? = null
)