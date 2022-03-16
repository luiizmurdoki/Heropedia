package com.example.heropedia.ui.information

import com.example.heropedia.data.response.AllInformationHero
import com.example.heropedia.data.service.HeroService
import com.example.heropedia.data.serviceGenerator.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformationPresenter : InformationContract.Presenter {

    private var view: InformationContract.View? = null

    override fun attachView(mvpView: InformationContract.View) {
        view = mvpView
    }
}
