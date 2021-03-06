package com.github.zhukdi.githubfetch.ui

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/*
 Primary Constructor Variables and their purpose

@Volatile var view: V
Volatile make sure the variable can  be accessed cross different threads

*/

open class Presenter<V>(@Volatile var view: V? ){

    companion object {
        var compositeDisposables: CompositeDisposable=CompositeDisposable()
    }

    init {
    }

    protected fun view(): V? {
        return view
    }

    @CallSuper
    fun unbindView() {
        compositeDisposables.clear()
        compositeDisposables.dispose()
        this.view = null
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposables.add(disposable)
    }

}