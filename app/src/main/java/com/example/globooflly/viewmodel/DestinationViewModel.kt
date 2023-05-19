package com.example.globooflly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.repositories.DestinationRepoImpl
import com.example.globooflly.repositories.DestinationRepositories

class DestinationViewModel : ViewModel() {
     val DestinationRepo:DestinationRepositories = DestinationRepoImpl()
     var promoMessage : MutableLiveData<String> = MutableLiveData()
     var listOfCountry:MutableLiveData<List<DestinationModel>> = MutableLiveData()
     var listUpdated:MutableLiveData<List<DestinationModel>> = MutableLiveData()

    fun getPromoData():LiveData<String>
    {
        promoMessage =  DestinationRepo.getPromoMessage()
        return promoMessage
    }

    fun getList():LiveData<List<DestinationModel>>{
        listOfCountry =  DestinationRepo.getCountryList()
        return listOfCountry
    }

    fun updateDestination(id:String , city: String, country: String, description: String):LiveData<List<DestinationModel>>{
        listUpdated = DestinationRepo.updateData( id , city , country , description)
        return listUpdated
    }

}