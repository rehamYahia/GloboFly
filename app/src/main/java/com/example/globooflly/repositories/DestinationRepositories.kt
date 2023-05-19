package com.example.globooflly.repositories

import androidx.lifecycle.MutableLiveData
import com.example.globooflly.model.DestinationModel

interface DestinationRepositories {
    fun getPromoMessage():MutableLiveData<String>
    fun getCountryList():MutableLiveData<List<DestinationModel>>
    fun updateData(id:String , city:String , country:String , description:String):MutableLiveData<List<DestinationModel>>
}