package com.github.zhukdi.githubfetch.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

class Issue(val id: Long, val title: String, val number: Long, @SerializedName("created_at") @Expose val createdAt: Date, val user: User)