package com.alvaromenezes.events.EventsDetail

import android.content.Context
import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.events.R
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
        presenter.loadEventDetatail(eventID)

        ivLocation.setOnClickListener { presenter.showMapLocation() }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

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
        tvPriceDetail.text = price

    }

    override fun showDate(date: String) {

        tvDateDetail.text = date
    }


    override fun showDescription(description: String) {
        tvDescription.text = description
    }
    override fun showMapLocation(lat: String, lon: String, title: String) {

        val strUri = "http://maps.google.com/maps?q=loc:$lat,$lon ($title)"
        val intent = Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri))

        intent.setClassName("com.google.android.apps.maps",
            "com.google.android.maps.MapsActivity")

        startActivity(intent)

    }


}