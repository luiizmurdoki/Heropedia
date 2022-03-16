package com.example.heropedia.ui.search

import com.example.heropedia.data.response.AllInformationHero
import com.example.heropedia.data.response.HeroInformation

interface SearchContract {
    interface View {
        fun displayError()
        fun displayLoading(loading: Boolean)
        fun adapterData(data : List<HeroInformation>)
    }

    interface Presenter {
        fun attachView(mvpView: SearchContract.View?)
        fun getSuperHeroList(name: String)
    }
}