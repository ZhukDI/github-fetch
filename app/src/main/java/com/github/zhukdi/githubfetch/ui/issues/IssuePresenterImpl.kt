package com.github.zhukdi.githubfetch.ui.issues

import android.app.Application
import com.github.zhukdi.githubfetch.GitHubFetchApplication
import com.github.zhukdi.githubfetch.network.IGitHubAPI
import com.github.zhukdi.githubfetch.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class IssuePresenterImpl(var issueView: IssueView, var applicationComponent: Application) : IssuePresenter, Presenter<IssueView>(issueView) {

    @Inject
    lateinit var mGithubApi : IGitHubAPI

    init {
        (applicationComponent as GitHubFetchApplication).applicationComponent.inject(this)
    }


    override fun getAllIssues(repoName: String) {
        val view = view()
        view?.let {
            it.showLoading()
            val issues = mGithubApi.getIssues(repoName)
            addDisposable(issues
                .subscribeOn(Schedulers.io())
                .repeatWhen { objectObservable -> objectObservable.delay(10, TimeUnit.SECONDS) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        view.let {
                            it.hideLoading()
                            issueView.showAllIssues(result)
                        }
                    },
                    { error ->
                        view.let {
                            it.hideLoading()

//                            Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            )
        }
    }
}