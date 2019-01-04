package com.alvaromenezes.events.Events


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.events.R
import com.alvaromenezes.events.data.Person
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.person_item.view.*


class PersonAdapter(val people: List<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        holder.bind(people[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return people.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(person: Person) {

            itemView.apply {

                with(person) {
                    Glide
                        .with(context)
                        .load(picture)
                        .apply(
                            RequestOptions()

                                .centerCrop()
                                .fitCenter()
                        )
                        .apply(RequestOptions.circleCropTransform())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ivPerson)

                    tvNamePerson.text = person.name
                }
            }

        }

    }
}