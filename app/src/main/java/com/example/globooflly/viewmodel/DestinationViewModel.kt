package com.example.globooflly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.repositories.DestinationRepoImpl
import com.example.globooflly.repositories.DestinationRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(private val destinationRepositories:DestinationRepositories) : ViewModel() {
     private var _promoMessage : MutableLiveData<String> = MutableLiveData()
     private var _listOfCountry:MutableLiveData<List<DestinationModel>> = MutableLiveData()
     private var _listUpdated:MutableLiveData<DestinationModel> = MutableLiveData()
     private var _ViewDetailData:MutableLiveData<DestinationModel> = MutableLiveData()
     private var _deleteData:MutableLiveData<Unit> = MutableLiveData()
    private var _addDestination:MutableLiveData<DestinationModel> = MutableLiveData()

    //method---------------------------------

    fun getPromoData():LiveData<String>
    {
        _promoMessage =  destinationRepositories.getPromoMessage()
        return _promoMessage
    }

    fun getList():LiveData<List<DestinationModel>>{
        _listOfCountry =  destinationRepositories.getCountryList()
        return _listOfCountry
    }

    //problem-----------
    fun updateDestination(id:String , city: String, country: String, description: String):LiveData<DestinationModel>{
        _listUpdated = destinationRepositories.updateData( id , city , country , description)
        return _listUpdated
    }

    fun ViewDetailModel(id:String) : LiveData<DestinationModel>{
        _ViewDetailData = destinationRepositories.viewDetailData(id)
        return _ViewDetailData
    }

    fun deleteDestination(id:String):LiveData<Unit>
    {
        _deleteData = destinationRepositories.deleteDestination(id)
        return _deleteData
    }

    fun AddNewDestination(destinationModel: DestinationModel):LiveData<DestinationModel>{
        _addDestination = destinationRepositories.addNewDestination(destinationModel)
        return _addDestination

    }

}