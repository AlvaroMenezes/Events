package com.alvaromenezes.events.service

import com.alvaromenezes.events.data.Event
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsAPI {

    @GET("events")
    fun getEvents(): Call< List<Event> >

    @GET("events/{eventID}")
    fun getEventByID(@Path("eventID") eventID: String ):  Call<Event>

    @POST("checkin")
    fun checkin(@Field("eventID") eventID: String, @Field("name") name: String , @Field("email") email: String ):  Call<Event>


}