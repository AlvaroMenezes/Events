package com.alvaromenezes.events.EventsDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alvaromenezes.events.R

class EventDetailActivity : AppCompatActivity() {

    companion object {
        const val EVENT_ID: String = "com.alvaromenezes.events.EventsDetail.EVENT_ID"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val eventID = intent.getStringExtra(EVENT_ID)
        showEventsFragment(eventID)
    }

    fun showEventsFragment(eventID: String) {

        val fragment = EventDetailFragment.newInstance(eventID)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentFrame, fragment)
            .commit()
    }

}
