package com.github.zhukdi.githubfetch.di.component

import com.github.zhukdi.githubfetch.GitHubFetchApplication
import com.github.zhukdi.githubfetch.di.module.AppModule
import com.github.zhukdi.githubfetch.di.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(mApplication : GitHubFetchApplication)

}