package com.example.globooflly.model

class DestinationModel {
    var id:String ?= null
    var city:String ?= null
    var description :String ?= null
    var country:String ?=null

    constructor(id: String?, city:String, description:String, country:String ){
        this.id = id
        this.city = city
        this.description = description
        this.country = country
    }
}