package com.alvaromenezes.events.Events


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.events.R
import com.alvaromenezes.events.data.Event
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

import kotlinx.android.synthetic.main.card_event_item.view.*


class EventsAdapter( val events: List<Event>,private val eventView: EventsContract.View ) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_event_item, parent, false)
        return ViewHolder(v,eventView)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }


     class ViewHolder(itemView: View, private val eventView: EventsContract.View) : RecyclerView.ViewHolder(itemView)  {


        fun bind(event: Event) {

            with(event) {
                with(itemView) {

                    Glide
                        .with(context)
                        .load(image)
                        .apply( RequestOptions()
                            .placeholder(R.drawable.no_image)
                            .centerCrop()
                            .fitCenter())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ivImage)

                    tvTitle.text = title
                    tvPrice.text = getPrice


                    setOnClickListener { this@ViewHolder.eventView.showDetail(event.id)  }
                }
            }
        }


    }


}                                 
