package com.example.globooflly.repositories

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import com.example.globooflly.ui.AddNewDestinationFragmentDirections
import com.example.globooflly.ui.DetailFragmentArgs
import com.example.globooflly.ui.DetailFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationRepoImpl(private val destinationServices: DestinationServices) :DestinationRepositories{
   private lateinit var _promoMessage:MutableLiveData<String>
   private  lateinit var countryList:MutableLiveData<List<DestinationModel>>
   private lateinit var listUpdated:MutableLiveData<DestinationModel>
   private lateinit var viewDetailData:MutableLiveData<DestinationModel>
   private lateinit var deleteData:MutableLiveData<Unit>
   private lateinit var AddDestination:MutableLiveData<DestinationModel>


    //methods--------------------------
    override fun getPromoMessage(): MutableLiveData<String> {
        _promoMessage = MutableLiveData()
        val call = destinationServices.getPromoMessge()
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    _promoMessage.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
            }
        })
        return _promoMessage
    }

    override fun getCountryList(): MutableLiveData<List<DestinationModel>> {
        countryList = MutableLiveData()
       val call= destinationServices.getAllDestinations()
        call.enqueue(object :Callback<List<DestinationModel>>{
            override fun onResponse(call: Call<List<DestinationModel>>, response: Response<List<DestinationModel>>) {
                if(response.isSuccessful)
                {
                    countryList.postValue(response.body())
                }

            }

            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
                //Toast.makeText(context ,t.message , Toast.LENGTH_LONG ).show()
            }

        })

       return countryList
    }

    override fun updateData(id:String , city: String, country: String, description: String): MutableLiveData<DestinationModel>
    {
        listUpdated = MutableLiveData()
        val call = destinationServices.updateDestination(id , city , country , description)
        call.enqueue(object : Callback<DestinationModel> {
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    listUpdated.postValue(response.body())
                    //Toast.makeText(context , "post updated sussefully " , Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                //Toast.makeText(context ,  t.message.toString() , Toast.LENGTH_LONG).show()
            }
        })
        return listUpdated
    }

    override fun viewDetailData(id:String): MutableLiveData<DestinationModel>{
        viewDetailData = MutableLiveData()
        val call = destinationServices.getDestinationsByID(id)
        call.enqueue(object :Callback<DestinationModel>{
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    viewDetailData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
            }
        })
        return viewDetailData
    }

    override fun deleteDestination(id: String): MutableLiveData<Unit> {
        deleteData = MutableLiveData()
        val call = destinationServices.deleteDestination(id)
        call.enqueue(object :Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                deleteData.postValue(response.body())
//                val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
//                navController.navigate(action)
//                Toast.makeText(activity , "delete successfully" , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
//                Toast.makeText(activity , t.message.toString() , Toast.LENGTH_LONG).show()
            }

        })
        return deleteData
    }

    override fun addNewDestination(destinationModel: DestinationModel): MutableLiveData<DestinationModel> {
        AddDestination = MutableLiveData()
        val call = destinationServices.addDestinationPost(DestinationModel(destinationModel.id ,destinationModel.city.toString() , destinationModel.description.toString() ,destinationModel.country.toString()))
        call.enqueue(object : Callback<DestinationModel> {
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    AddDestination.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
            }

        })
        return AddDestination

    }


}