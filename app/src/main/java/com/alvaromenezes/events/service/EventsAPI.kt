package com.alvaromenezes.events.service

import com.alvaromenezes.events.data.Event
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface EventsAPI {

    @GET("events")
    fun getEvents(): Call<List<Event>>

    @GET("events/{eventID}")
    fun getEventByID(@Path("eventID") eventID: String): Call<Event>

    @POST("checkin")
    @FormUrlEncoded
    fun checkin(@Field("eventID") eventID: String, @Field("name") name: String, @Field("email") email: String): Call<ResponseBody>


}