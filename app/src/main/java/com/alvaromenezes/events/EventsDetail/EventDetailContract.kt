package com.alvaromenezes.events.EventsDetail


interface EventDetailContract {


    interface View {

        fun loadImage(urlImage: String)
        fun showTitle(title: String)
        fun showPrice(price: String)
        fun showDate(date: String)
        fun showDescription(description: String)
        fun showMapLocation(lat: String, lon: String, title: String)


    }

    interface Presenter {
        fun loadEventDetatail(eventID: String)
        fun showEventDetail()
        fun showMapLocation()
        fun attach(view: EventDetailContract.View)
    }


}