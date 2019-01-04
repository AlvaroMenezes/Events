package com.alvaromenezes.events.EventsDetail

import com.alvaromenezes.events.data.Event

class EventDetailPresenter : EventDetailContract.Presenter{

    private lateinit var view: EventDetailContract.View
    private lateinit var eventID: String

    override fun loadEventDetatail(eventID :String) {
        this.eventID = eventID

       var event =  Event(
            "id",
            "tile1",
            21.1,
            image = "http://lproweb.procempa.com.br/pmpa/prefpoa/seda_news/usu_img/Papel%20de%20Parede.png"
        )

        with(event){
            with(view){

                showPrice(getPrice)
                loadImage(image)

            }
        }



    }

    override fun attach(view: EventDetailContract.View) {

        this.view = view
    }
}