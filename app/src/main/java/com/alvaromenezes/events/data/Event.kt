package com.alvaromenezes.events.data

import java.text.SimpleDateFormat
import java.util.*


class Event(
    val id: String,
    val title: String,
    val price: Double,
    val latitude: String = "",
    val longitude: String = "",
    val image: String = "",
    val description: String = "",
    val date: Long = 1,
    people: List<Person>? = null,
    cupons: List<Coupon>? = null
) {

    val getPrice: String
        get() {
            return "R$ %.2f".format(price)
        }

    val getDate: String
        get() {

            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date(date)
            return sdf.format(netDate)
        }
}