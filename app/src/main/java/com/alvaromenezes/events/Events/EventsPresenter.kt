package com.alvaromenezes.events.Events

import com.alvaromenezes.events.data.Event
import javax.inject.Inject

class EventsPresenter @Inject constructor() : EventsContract.Presenter {


    private lateinit var view: EventsContract.View

    override fun attach(view: EventsContract.View) {
        this.view = view

        this.view.toast()


    }

    override fun loadEvents() {

        val items = listOf(
            Event(
                "id",
                "tile1",
                21.1,
                image = "http://lproweb.procempa.com.br/pmpa/prefpoa/seda_news/usu_img/Papel%20de%20Parede.pngxxx"
            ),
            Event(
                "id",
                "tile2",
                21.1,
                image = "https://images.pexels.com/photos/1292306/pexels-photo-1292306.jpeg"
            )
        )


        view.showEvents(items)
    }


}