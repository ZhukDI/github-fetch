package com.github.zhukdi.githubfetch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.github.zhukdi.githubfetch.adapters.IssueAdapter
import com.github.zhukdi.githubfetch.models.Issue
import com.github.zhukdi.githubfetch.network.GitHubClient
import com.github.zhukdi.githubfetch.network.IGitHubIssueAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var jsonIssueApi: IGitHubIssueAPI
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = GitHubClient.instance
        jsonIssueApi = retrofit.create(IGitHubIssueAPI::class.java)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonIssueApi
            .getIssues()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                issues -> displayData(issues)
            }, {
                Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
            })
        )
    }

    private fun displayData(issues: List<Issue>?) {
        val adapter = IssueAdapter(issues!!)
        recyclerView.adapter = adapter
    }
}
