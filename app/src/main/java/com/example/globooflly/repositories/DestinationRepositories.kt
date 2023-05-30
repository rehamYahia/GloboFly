package com.example.globooflly.repositories

import androidx.lifecycle.MutableLiveData
import com.example.globooflly.model.DestinationModel
import kotlinx.coroutines.flow.StateFlow

interface DestinationRepositories {
    //remote
    suspend fun getPromoMessage():String
    suspend fun getCountryList():ArrayList<DestinationModel>

    suspend fun updateData(id:String , city:String , country:String , description:String):DestinationModel

    suspend fun viewDetailData(id:String):DestinationModel

   suspend fun deleteDestination(id:String)

   suspend fun addNewDestination(destinationModel: DestinationModel):DestinationModel

   //local database
   suspend fun RinsertPlace(destinationModel: DestinationModel)
//    suspend fun RgetAllPlaces(): StateFlow<ArrayList<DestinationModel>>
//
//    suspend fun RupdatePlace(id:String , city:String , description :String , country:String)
//    suspend fun RdeletePlace(id:String) :Unit
}