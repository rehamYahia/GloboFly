package com.example.globooflly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.repositories.DestinationRepoImpl
import com.example.globooflly.repositories.DestinationRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(private val destinationRepositories:DestinationRepositories)
    : ViewModel() {
     private val _promoMessage : MutableStateFlow<String?> = MutableStateFlow(null)
      val  promoMessage : StateFlow<String?> = _promoMessage

     private val _listOfCountry:MutableStateFlow<ArrayList<DestinationModel>?> = MutableStateFlow(null)
     val  listOfCountry:StateFlow<ArrayList<DestinationModel>?> = _listOfCountry

     private val _listUpdated:MutableStateFlow<DestinationModel?> = MutableStateFlow(null)
     val listUpdated:StateFlow<DestinationModel?> = _listUpdated

     private val _ViewDetailData:MutableStateFlow<DestinationModel?> = MutableStateFlow(null)
     val ViewDetailData:StateFlow<DestinationModel?> = _ViewDetailData

//     private val _deleteData:MutableStateFlow<Unit?> = MutableStateFlow(null)
//     val deleteData:StateFlow<Unit?> = _deleteData

    private val _addDestination:MutableStateFlow<DestinationModel?> = MutableStateFlow(null)
     val addDestination:StateFlow<DestinationModel?> = _addDestination


    //method---------------------------------

    fun getPromoData()
    {
        viewModelScope.launch {
            _promoMessage.value = destinationRepositories.getPromoMessage()
        }
    }

    fun getList(){
        viewModelScope.launch {
            _listOfCountry.value =  destinationRepositories.getCountryList()
        }

    }

    fun updateDestination(id:String , city: String, country: String, description: String){
        viewModelScope.launch {
            _listUpdated.value = destinationRepositories.updateData( id , city , country , description)
        }

    }

    fun ViewDetailModel(id:String){
        viewModelScope.launch {
            _ViewDetailData.value = destinationRepositories.viewDetailData(id)
        }

    }

    fun deleteDestination(id:String)
    {
        viewModelScope.launch {
//            _deleteData.value = destinationRepositories.deleteDestination(id)
            destinationRepositories.deleteDestination(id)
        }
    }

    fun AddNewDestination(destinationModel: DestinationModel){
        viewModelScope.launch {
            _addDestination.value = destinationRepositories.addNewDestination(destinationModel)
        }
    }

    fun VinsertPlace(destinationModel: DestinationModel){
        viewModelScope.launch {
            destinationRepositories.RinsertPlace(destinationModel)
        }
    }



}