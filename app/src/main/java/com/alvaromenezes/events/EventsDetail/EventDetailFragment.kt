package com.alvaromenezes.events.EventsDetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.alvaromenezes.events.Events.PersonAdapter
import com.alvaromenezes.events.R
import com.alvaromenezes.events.data.Person
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_event_detail.*


private const val ARG_EVENT_ID = "event_id"


class EventDetailFragment : Fragment(), EventDetailContract.View {


    private lateinit var eventID: String


    private lateinit var presenter: EventDetailPresenter


    companion object {

        @JvmStatic
        fun newInstance(eventID: String) =
            EventDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_EVENT_ID, eventID)
                }
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            eventID = it.getString(ARG_EVENT_ID)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_event_detail, container, false)
    }

    override fun onStart() {
        super.onStart()

        presenter = EventDetailPresenter()
        presenter.attach(this)
        presenter.loadEventDetail(eventID)

        ivLocation.setOnClickListener { presenter.showMapLocation() }
        ibCheckin.setOnClickListener {presenter.initCheckin() }

        scrollDetail.smoothScrollTo(0,0)

    }


    override fun showPeople(people: List<Person>) {
        if(people == null) return

        reciclerViewPerson.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = PersonAdapter(people)
        }
    }


    override fun loadImage(urlImage: String) {
        Glide
            .with(context!!)
            .load(urlImage)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.no_image)
                    .centerCrop()
                    .fitCenter()
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(ivImageDetail)

    }

    override fun showTitle(title: String) {

        tvTitleDetail.text = title
    }

    override fun showPrice(price: String) {
        tvPriceDetail.text = "Valor: $price"

    }

    override fun showDate(date: String) {

        tvDateDetail.text = "Quando: $date"
    }


    override fun showDescription(description: String) {
        tvDescription.text = description
    }

    override fun showMapLocation(lat: String, lon: String, title: String) {

        val strUri = "http://maps.google.com/maps?q=loc:$lat,$lon ($title)"
        val intent = Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri))

        intent.setClassName(
            "com.google.android.apps.maps",
            "com.google.android.maps.MapsActivity"
        )

        startActivity(intent)

    }

    override fun onCheckin() {


        val builder = AlertDialog.Builder(this!!.context!!)
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.checkin_dialog, null)

         var name = view.findViewById<EditText>(R.id.etNameCheckin)
         var email = view.findViewById<EditText>(R.id.etEmailCheckin)

        builder.setView(view)

            .setPositiveButton(R.string.checkin) { dialog, id ->

                presenter.OnChekin(name.text.toString(),
                                     email.text.toString())

            }
            .setNegativeButton(R.string.cancel
            ) { dialog, id ->  }
         builder.create().show()

    }


    override fun checkinSuccess() {
        Toast.makeText(context,"Check in realizado com sucesso!",Toast.LENGTH_SHORT).show()
        activity!!.finish()

    }

    override fun checkinFail() {

        Toast.makeText(context,"Nao foi possivel realizar o check in",Toast.LENGTH_SHORT).show()
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }


}
