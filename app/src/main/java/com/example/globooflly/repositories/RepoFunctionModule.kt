package com.example.globooflly.repositories

import androidx.lifecycle.MutableLiveData
import com.example.globooflly.model.DestinationModel

interface RepoFunctionModule {

    fun getPromoMessage(): MutableLiveData<String>
    fun getCountryList(): MutableLiveData<List<DestinationModel>>

    //problem-----------
    fun updateData(id:String , city:String , country:String , description:String): MutableLiveData<DestinationModel>

    fun viewDetailData(id:String): MutableLiveData<DestinationModel>

    fun deleteDestination(id:String): MutableLiveData<Unit>

    fun addNewDestination(destinationModel: DestinationModel): MutableLiveData<DestinationModel>
}