package com.alvaromenezes.events.di

import com.alvaromenezes.events.Events.EventsActivity
import com.alvaromenezes.events.Events.EventsFragment
import dagger.Component

@Component
interface AppComponent {
    fun inject(app: EventsActivity)
    fun inject(fragment: EventsFragment)
}