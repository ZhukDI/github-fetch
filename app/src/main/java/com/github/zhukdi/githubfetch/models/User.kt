package com.github.zhukdi.githubfetch.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(val id: Long, val login: String, @SerializedName("avatar_url") @Expose val avatarUrl: String)
