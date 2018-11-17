package com.github.zhukdi.githubfetch.di.component

import com.github.zhukdi.githubfetch.GitHubFetchApplication
import com.github.zhukdi.githubfetch.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(mApplication : GitHubFetchApplication)

}