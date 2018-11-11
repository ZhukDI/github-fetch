package com.github.zhukdi.githubfetch.network

import com.github.zhukdi.githubfetch.models.Issue
import io.reactivex.Observable
import retrofit2.http.GET

interface IGitHubIssueAPI {

    @GET(UrlManager.ISSUES)
    fun getIssues() : Observable<List<Issue>>

}