package com.github.zhukdi.githubfetch.model

class Issue {
    var id: Long = 0
    var title: String = ""
    var number: Long = 0
    var createdAt: String = "" // change in Date

    val user: User? = null
}