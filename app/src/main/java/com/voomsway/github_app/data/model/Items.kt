package com.voomsway.github_app.data.model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("stargazers_count")
    val stargazers_count: Int,
    @SerializedName("avatar_url")
    val avatar_url: String
) 