package com.example.globooflly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.globooflly.databinding.ActivityAddNewDestinationBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddNewDestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewDestinationBinding
    //var postId:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewDestinationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.addDestinationToolbar)

        binding.serverAddBtn.setOnClickListener{

            val service = DeestinationRetrofit.getService(DestinationServices::class.java)
            val call = service.addDestinationPost(DestinationModel(null ,binding.addCityName.editText?.text.toString() , binding.addDescription.editText?.text.toString() ,binding.addCountryName.editText?.text.toString()))
            call.enqueue(object :Callback<DestinationModel>{
                override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                    if(response.isSuccessful){
                        finish()
                        Toast.makeText(this@AddNewDestinationActivity , "post add sussefully " ,Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                    Toast.makeText(this@AddNewDestinationActivity ,  t.message.toString() ,Toast.LENGTH_LONG).show()
                }

            })

        }

    }


}