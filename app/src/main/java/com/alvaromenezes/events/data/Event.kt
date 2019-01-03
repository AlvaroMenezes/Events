package com.alvaromenezes.events.data

class Event (val id:String, val title:String, val price: Double, val latitude:String, val longitude:String,
             val image:String, val description:String,  val date: Long, people : List<Person>, cupons : List<Coupon>  )