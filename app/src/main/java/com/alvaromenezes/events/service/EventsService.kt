package com.alvaromenezes.events.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsService {

    private val basURL = "http://5b840ba5db24a100142dcd8c.mockapi.io/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(basURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun API() = retrofit.create(EventsAPI::class.java)

}