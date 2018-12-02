package com.github.zhukdi.githubfetch.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.zhukdi.githubfetch.R
import com.github.zhukdi.githubfetch.ui.adapters.IssueAdapter
import com.github.zhukdi.githubfetch.models.Issue
import com.github.zhukdi.githubfetch.ui.BaseActivity
import com.github.zhukdi.githubfetch.ui.issues.IssuePresenterImpl
import com.github.zhukdi.githubfetch.ui.issues.IssueView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), IssueView {

    var issuePresenter: IssuePresenterImpl?=null

    private fun getPresenter(): IssuePresenterImpl?{
        issuePresenter = IssuePresenterImpl(this, application)
        return issuePresenter
    }

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        search_btn.setOnClickListener {
            val searchText = search_field.text.toString()
            getPresenter()?.let {
                it.getAllIssues(searchText)
            }
        }
    }

    override fun onStartScreen() {
    }

    override fun stopScreen() {
        issuePresenter?.let {
            issuePresenter!!.unbindView()
            issuePresenter = null
        }
    }

    override fun showAllIssues(issueList: List<Issue>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = IssueAdapter(issueList!!)
        recyclerView.adapter = adapter
    }

}
