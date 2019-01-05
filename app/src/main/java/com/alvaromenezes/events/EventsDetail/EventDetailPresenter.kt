package com.alvaromenezes.events.EventsDetail

import com.alvaromenezes.events.data.Event
import com.alvaromenezes.events.service.EventsService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EventDetailPresenter : EventDetailContract.Presenter {

    private lateinit var view: EventDetailContract.View
    private lateinit var eventID: String
    private  var event: Event? = null

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

        if(event == null) return

        view.showPeople(event?.people!!)
    }

    override fun OnChekin(name: String, email: String) {

        val call = EventsService().API().checkin(eventID,name,email)

        call.enqueue(object : Callback<ResponseBody?> {

            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {

                if (response != null) {
                    if (response.isSuccessful) {
                        view.checkinSuccess()

                    }
                }
            }
            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    view.checkinFail()
            }
        })

    }


    override fun attach(view: EventDetailContract.View) {
        this.view = view
    }


    override fun showMapLocation() {
        if(event == null) return
        view.showMapLocation(event!!.latitude, event!!.longitude, event!!.title)
    }

    override fun showEventDetail() {

        if(event == null) return

        view.apply {
            with(event) {
                showPrice(this!!.getPrice)
                loadImage(image)
                showDate(getDate)
                showTitle(title)
                showDescription(description)
            }
        }

        showPeople()
    }

}