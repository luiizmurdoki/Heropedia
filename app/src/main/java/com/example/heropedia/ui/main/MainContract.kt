package com.example.heropedia.ui.main

interface MainContract {
    interface View {
        fun displayError()
    }

    interface Presenter {
        fun attachView(mvpView: MainContract.View?)
    }
}