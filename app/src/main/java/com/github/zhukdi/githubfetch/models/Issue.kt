package com.github.zhukdi.githubfetch.models

import java.util.Date

class Issue(val id: Long, val title: String, val number: Long, val createdAt: Date, val user: User)