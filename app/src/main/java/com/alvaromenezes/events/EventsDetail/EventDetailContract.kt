package com.alvaromenezes.events.EventsDetail


import com.alvaromenezes.events.data.Event

interface EventDetailContract {


    interface View {

        fun loadImage(urlImage: String)
        fun showTitle(title:String)
        fun showPrice(price:String)
        fun showDate(date:String)
        fun showMapLocation(date:String)


    }

    interface Presenter {
        fun loadEventDetatail(eventID :String)
        fun attach(view: EventDetailContract.View)
    }





}