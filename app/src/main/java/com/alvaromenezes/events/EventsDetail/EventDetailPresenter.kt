package com.alvaromenezes.events.EventsDetail

import com.alvaromenezes.events.data.Event
import com.alvaromenezes.events.data.Person

class EventDetailPresenter : EventDetailContract.Presenter {


    private lateinit var view: EventDetailContract.View
    private lateinit var eventID: String
    private lateinit var event: Event

    override fun loadEventDetail(eventID: String) {
        this.eventID = eventID

        event = Event(
            "id",
            "tile1",
            21.1,
            date = 1534784400000,
            latitude = "-30.0392981",
            longitude = "-51.2146267",
            image = "http://lproweb.procempa.com.br/pmpa/prefpoa/seda_news/usu_img/Papel%20de%20Parede.png",
            description = "orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "Why do we use it?\n" +
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                    "\n" +
                    "\n"
        )

        showEventDetail()
    }

    override fun showPeople() {

        val people = listOf<Person>(


            Person(
                name = "Alexandre Pires",
                picture = "https://images.pexels.com/photos/1292306/pexels-photo-1292306.jpeg"
            ),

            Person(
                name = "JÃ©ssica Souza",
                picture = "https://images.pexels.com/photos/1310522/pexels-photo-1310522.jpeg"
            ),
            Person(
                name = "Boanerges Oliveira",
                picture = "https://images.pexels.com/photos/542282/pexels-photo-542282.jpeg"
            ),
            Person(name = "Felipe Smith", picture = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg"),
            Person(
                name = "Paulo Santos",
                picture = "https://images.pexels.com/photos/1334945/pexels-photo-1334945.jpeg"
            )


        )

        view.showPeople(people)

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