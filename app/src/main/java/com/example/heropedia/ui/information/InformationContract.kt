package com.example.heropedia.ui.information

import com.example.heropedia.data.response.HeroInformation
import com.example.heropedia.ui.search.SearchContract

interface InformationContract {
    interface View {
        fun displayError()
        fun displayLoading(loading: Boolean)
    }

    interface Presenter {
        fun attachView(mvpView: InformationContract.View)
    }
}