package com.example.globooflly.repositories

import androidx.lifecycle.MutableLiveData
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices

class RepoImplementation(private val destinationServices: DestinationServices) :RepoFunctionModule {
    override fun getPromoMessage(): MutableLiveData<String> {
        TODO("Not yet implemented")
    }

    override fun getCountryList(): MutableLiveData<List<DestinationModel>> {
        TODO("Not yet implemented")
    }

    override fun updateData(
        id: String,
        city: String,
        country: String,
        description: String
    ): MutableLiveData<DestinationModel> {
        TODO("Not yet implemented")
    }

    override fun viewDetailData(id: String): MutableLiveData<DestinationModel> {
        TODO("Not yet implemented")
    }

    override fun deleteDestination(id: String): MutableLiveData<Unit> {
        TODO("Not yet implemented")
    }

    override fun addNewDestination(destinationModel: DestinationModel): MutableLiveData<DestinationModel> {
        TODO("Not yet implemented")
    }
}