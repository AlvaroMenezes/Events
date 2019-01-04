package com.alvaromenezes.events.Events

import com.alvaromenezes.events.data.Event

class EventsPresenter() : EventsContract.Presenter {


    private lateinit var view: EventsContract.View

    override fun attach(view: EventsContract.View) {
      this.view = view
    }

    override fun loadEvents() {
        
        val items = listOf(Event("id","tile1",21.1 ), Event("id","tile2",21.1 ))


    }


}