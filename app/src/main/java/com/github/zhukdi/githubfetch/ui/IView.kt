package com.github.zhukdi.githubfetch.ui

interface IView{

    fun showLoading()

    fun hideLoading()

    fun loadError(e: Throwable)

    fun loadError(msg: String)

}