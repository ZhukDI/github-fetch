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

//class MainActivity : AppCompatActivity() {
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

//    private lateinit var jsonIssueApi: IGitHubAPI
//    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
//
//    @Override
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        search_btn.setOnClickListener {
//            val searchText = search_field.text.toString()
//
//            searchIssues(searchText)
//        }
//
//        val retrofit = GitHubClient.instance
//        jsonIssueApi = retrofit.create(IGitHubAPI::class.java)
//
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//    }
//
//    private fun searchIssues(repoName: String) {
//        compositeDisposable.add(jsonIssueApi
//            .getIssues(repoName)
//            .repeatWhen { objectObservable -> objectObservable.delay(10, TimeUnit.SECONDS) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                issues -> displayData(issues)
//            }, {
//                Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
//            })
//        )
//    }
//
//    private fun displayData(issues: List<Issue>?) {
//        val adapter = IssueAdapter(issues!!)
//        recyclerView.adapter = adapter
//    }
}
