package com.alvaromenezes.events.Events

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.events.R
import com.alvaromenezes.events.data.Event

import kotlinx.android.synthetic.main.card_event_item.view.*


class EventsAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_event_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(event: Event) {

            with(event) {
                with(itemView) {

                    tvTitle.setText(title)
                    tvPrice.setText("{R$ $price}")
                }
            }
        }
    }


}
