package com.alvaromenezes.events.Events

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alvaromenezes.events.R

class EventsActivity : AppCompatActivity() {

    private lateinit var presenter: EventsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        showEventsFragment()
    }

    fun showEventsFragment() {

        val fragment = EventsFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentFrame, fragment)
            .commit()
    }

}
