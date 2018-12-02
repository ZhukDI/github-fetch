package com.github.zhukdi.githubfetch.ui.issues

import com.github.zhukdi.githubfetch.models.Issue
import com.github.zhukdi.githubfetch.ui.IView

interface IssueView : IView {

    fun showAllIssues(issueList: List<Issue>)

}