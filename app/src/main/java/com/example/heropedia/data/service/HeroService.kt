package com.example.heropedia.data.service

import com.example.heropedia.data.response.AllInformationHero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface HeroService {

    @GET
    fun searchHero(@Url url :String): Call<AllInformationHero>

}