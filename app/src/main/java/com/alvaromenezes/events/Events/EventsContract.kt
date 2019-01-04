package com.alvaromenezes.events.Events

import com.alvaromenezes.events.data.Event


interface EventsContract {

    interface View {

        fun showProgress(visible: Boolean)
        fun showEvents(Events: List<Event>)
        fun showDetail(eventId: Int)
        fun toast()


    }

    interface Presenter {
        fun loadEvents()
        fun attach(view: EventsContract.View)
    }


}