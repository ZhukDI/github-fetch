package com.github.zhukdi.githubfetch.network

import com.github.zhukdi.githubfetch.models.Issue
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IGitHubIssueAPI {

    @GET(UrlManager.ISSUES)
    fun getIssues(@Path("repo-name") repoName: String) : Observable<List<Issue>>

}