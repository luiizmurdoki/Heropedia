package com.example.heropedia.ui.search

import com.example.heropedia.data.response.AllInformationHero
import com.example.heropedia.data.service.HeroService
import com.example.heropedia.data.serviceGenerator.ServiceGenerator
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SearchPresenter : SearchContract.Presenter {

    private var view: SearchContract.View? = null

    override fun attachView(mvpView: SearchContract.View?) {
        view = mvpView
    }

    override fun getSuperHeroList(name: String) {
        view?.displayLoading(true)
        ServiceGenerator().retrofit.create(HeroService::class.java).searchHero(url = "search/$name")
            .enqueue(object : Callback<AllInformationHero> {
                override fun onResponse(
                    call: Call<AllInformationHero?>,
                    response: Response<AllInformationHero?>
                ) {
                    view?.displayLoading(false)
                    if (response.body()?.response != "error") response.body()?.let { view?.adapterData(it.results.toList()) }
                    else  view?.displayError()
                }

                override fun onFailure(call: Call<AllInformationHero>, t: Throwable) {
                    view?.displayLoading(false)
                    view?.displayError()
                }
            })
    }
}