package com.github.zhukdi.githubfetch.network

import com.github.zhukdi.githubfetch.models.Issue
import io.reactivex.Observable
import retrofit2.http.GET

interface IGitHubIssueAPI {

    @get: GET("issues")
    val ussues: Observable<List<Issue>>

}