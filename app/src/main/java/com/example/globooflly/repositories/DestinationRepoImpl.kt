package com.example.globooflly.repositories

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import com.example.globooflly.ui.DetailFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationRepoImpl :DestinationRepositories{
   private lateinit var _promoMessage:MutableLiveData<String>
   private  lateinit var countryList:MutableLiveData<List<DestinationModel>>
   private lateinit var context: Context
   private lateinit var listUpdated:MutableLiveData<List<DestinationModel>>
   private lateinit var navController: NavController
    val service = DeestinationRetrofit.getService(DestinationServices::class.java)
    override fun getPromoMessage(): MutableLiveData<String> {
        _promoMessage = MutableLiveData()
        val call = service.getPromoMessge("http://10.0.2.2:7000/messages")
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    //binding.textFromServer.text  = response.body()
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
       val call= service.getAllDestinations()
        call.enqueue(object :Callback<List<DestinationModel>>{
            override fun onResponse(call: Call<List<DestinationModel>>, response: Response<List<DestinationModel>>) {
                if(response.isSuccessful)
                {
                    countryList.postValue(response.body())
                }

            }

            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
                Toast.makeText(context ,t.message , Toast.LENGTH_LONG ).show()
            }

        })

       return countryList
    }

    override fun updateData(id:String , city: String, country: String, description: String): MutableLiveData<List<DestinationModel>>
    {
        listUpdated = MutableLiveData()
        val call = service.updateDestination(id , city , country , description)

        call.enqueue(object : Callback<DestinationModel> {
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                    navController.navigate(action)
                    Toast.makeText(context , "post updated sussefully " , Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                Toast.makeText(context ,  t.message.toString() , Toast.LENGTH_LONG).show()
            }
        })
        return listUpdated
    }

}