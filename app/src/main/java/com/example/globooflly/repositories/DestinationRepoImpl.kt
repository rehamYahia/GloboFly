package com.example.globooflly.repositories

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.globooflly.database.DestinationDao
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.ui.AddNewDestinationFragmentDirections
import com.example.globooflly.ui.DetailFragmentArgs
import com.example.globooflly.ui.DetailFragmentDirections
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DestinationRepoImpl (private val destinationServices: DestinationServices , private val destinationDao: DestinationDao) :DestinationRepositories{
//   private lateinit var _promoMessage:MutableLiveData<String>
//   private  lateinit var countryList:MutableLiveData<List<DestinationModel>>
//   private lateinit var listUpdated:MutableLiveData<DestinationModel>
//   private lateinit var viewDetailData:MutableLiveData<DestinationModel>
//   private lateinit var deleteData:MutableLiveData<Unit>
//   private lateinit var AddDestination:MutableLiveData<DestinationModel>
   override suspend fun getPromoMessage(): String = destinationServices.getPromoMessge()


   override suspend fun getCountryList(): ArrayList<DestinationModel> = destinationServices.getAllDestinations()

   override suspend fun updateData(id: String, city: String, country: String, description: String)
   : DestinationModel  = destinationServices.updateDestination(id , city , country , description)



   override suspend fun viewDetailData(id: String): DestinationModel = destinationServices.getDestinationsByID(id)

   override suspend fun deleteDestination(id: String) =
      destinationServices.deleteDestination(id)


   override suspend fun addNewDestination(destinationModel: DestinationModel): DestinationModel = destinationServices.addDestinationPost(destinationModel)

   //local database
   override suspend fun RinsertPlace(destinationModel: DestinationModel) {
      destinationDao.insertPlace(destinationModel)
   }

//   override suspend fun RgetAllPlaces(): StateFlow<ArrayList<DestinationModel>> = destinationDao.getAllPlaces()
//
//   override suspend fun RupdatePlace(id: String, city: String, description: String, country: String) {
//      destinationDao.updatePlace(id ,city , description , country)
//   }
//
//   override suspend fun RdeletePlace(id: String) {
//      destinationDao.deletePlace(id)
//   }


}