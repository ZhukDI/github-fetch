package com.github.zhukdi.githubfetch

import android.app.Application
import com.github.zhukdi.githubfetch.di.component.ApplicationComponent
import com.github.zhukdi.githubfetch.di.component.DaggerApplicationComponent
import com.github.zhukdi.githubfetch.di.module.NetModule

open class GitHubFetchApplication : Application() {

    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .netModule(NetModule())
            .build()

        applicationComponent.inject(this)
    }
}