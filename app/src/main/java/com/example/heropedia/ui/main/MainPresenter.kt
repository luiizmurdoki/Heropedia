package com.example.heropedia.ui.main

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attachView(mvpView: MainContract.View?) {
        view = mvpView
    }
}