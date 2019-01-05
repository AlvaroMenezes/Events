package com.alvaromenezes.events.EventsDetail

import com.alvaromenezes.events.data.Event
import com.alvaromenezes.events.service.EventsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventDetailPresenter : EventDetailContract.Presenter {

    private lateinit var view: EventDetailContract.View
    private lateinit var eventID: String
    private lateinit var event: Event

    override fun loadEventDetail(eventID: String) {
        this.eventID = eventID


        val call = EventsService().API().getEventByID(eventID)
        call.enqueue(object : Callback<Event?> {

            override fun onResponse(call: Call<Event?>, response: Response<Event?>) {

                if (response != null) {
                    if (response.isSuccessful) {
                        event = response.body()!!
                        showEventDetail()

                    }
                }
            }

            override fun onFailure(call: Call<Event?>, t: Throwable) {

            }

        })

    }

    override fun showPeople() {

        view.showPeople(event.people!!)
    }

    override fun OnChekin() {


    }


    override fun attach(view: EventDetailContract.View) {
        this.view = view
    }


    override fun showMapLocation() {
        view.showMapLocation(event.latitude, event.longitude, event.title)
    }

    override fun showEventDetail() {

        view.apply {
            with(event) {
                showPrice(getPrice)
                loadImage(image)
                showDate(getDate)
                showTitle(title)
                showDescription(description)
            }
        }

        showPeople()
    }

}