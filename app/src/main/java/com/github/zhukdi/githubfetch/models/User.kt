package com.github.zhukdi.githubfetch.models

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id") val id: Long,
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
