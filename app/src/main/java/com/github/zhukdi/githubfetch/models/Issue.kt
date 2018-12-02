package com.github.zhukdi.githubfetch.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Issue(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("number") val number: Long,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("user") val user: User
)