package com.alvaromenezes.events.EventsDetail

import com.alvaromenezes.events.data.Person


interface EventDetailContract {

    interface View {
        fun loadImage(urlImage: String)
        fun showTitle(title: String)
        fun showPrice(price: String)
        fun showDate(date: String)
        fun showDescription(description: String)
        fun showMapLocation(lat: String, lon: String, title: String)
        fun showPeople(people: List<Person>)

        fun onCheckin()

        fun checkinSuccess()
        fun checkinFail()
    }

    interface Presenter {
        fun loadEventDetail(eventID: String)
        fun showEventDetail()
        fun showPeople()
        fun showMapLocation()
        fun attach(view: EventDetailContract.View)
        fun OnChekin(name: String, email : String )
    }

}