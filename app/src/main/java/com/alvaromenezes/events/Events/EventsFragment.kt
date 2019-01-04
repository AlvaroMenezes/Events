package com.alvaromenezes.events.Events

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alvaromenezes.events.R
import com.alvaromenezes.events.data.Event
import com.alvaromenezes.events.di.DaggerAppComponent
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject


class EventsFragment : Fragment(), EventsContract.View {
    override fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Inject
    lateinit var presenter: EventsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.create().inject(this)

        presenter.attach(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_events, container, false)
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

    override fun onStart() {
        super.onStart()
        presenter.loadEvents()
    }

    override fun showProgress(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEvents(events: List<Event>) {

        reciclerViewEvents.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        reciclerViewEvents.adapter = EventsAdapter(events,this)
    }

    override fun showDetail(eventId: String) {


    }


}
