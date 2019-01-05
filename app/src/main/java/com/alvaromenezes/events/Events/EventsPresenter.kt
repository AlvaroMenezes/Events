package com.alvaromenezes.events.Events

import com.alvaromenezes.events.data.Event
import com.alvaromenezes.events.service.EventsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EventsPresenter @Inject constructor() : EventsContract.Presenter {


    private lateinit var view: EventsContract.View

    override fun attach(view: EventsContract.View) {
        this.view = view
    }

    override fun loadEvents() {

        val call = EventsService().API().getEvents()
        call.enqueue(object : Callback<List<Event>?> {

            override fun onResponse(call: Call<List<Event>?>?, response: Response<List<Event>?>?) {

                if (response != null) {
                    if (response.isSuccessful) {
                        view.showEvents(response.body()!!)

                    }
                }

            }

            override fun onFailure(call: Call<List<Event>?>?, t: Throwable?) {

            }
        })
    }


}