package com.example.globooflly.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableDestination")
class DestinationModel {
//    @PrimaryKey(autoGenerate = true)
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