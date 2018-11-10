package com.github.zhukdi.githubfetch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.zhukdi.githubfetch.adapters.IssueAdapter
import com.github.zhukdi.githubfetch.models.Issue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val issueList = listOf<Issue>(
            Issue(1, "title", 1, "08.11.2018"),
            Issue(2, "title2", 2, "09.11.2018"),
            Issue(3, "title3", 3, "10.11.2018")
        )
        recyclerView.adapter = IssueAdapter(issueList)

//        fetchJson()
    }
}
