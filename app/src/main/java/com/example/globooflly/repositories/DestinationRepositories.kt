package com.example.globooflly.repositories

import androidx.lifecycle.MutableLiveData
import com.example.globooflly.model.DestinationModel

interface DestinationRepositories {
    suspend fun getPromoMessage():String
    suspend fun getCountryList():List<DestinationModel>

    //problem-----------
    suspend fun updateData(id:String , city:String , country:String , description:String):DestinationModel

    suspend fun viewDetailData(id:String):DestinationModel

   suspend fun deleteDestination(id:String):Unit

   suspend fun addNewDestination(destinationModel: DestinationModel):DestinationModel
}