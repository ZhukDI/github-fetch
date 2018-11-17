package com.github.zhukdi.githubfetch

import android.app.Application
import com.github.zhukdi.githubfetch.di.component.ApplicationComponent
import com.github.zhukdi.githubfetch.di.component.DaggerApplicationComponent
import com.github.zhukdi.githubfetch.di.module.ApplicationModule

open class GitHubFetchApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule())
            .build()

        applicationComponent.inject(this)
    }
}