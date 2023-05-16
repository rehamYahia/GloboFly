package com.example.globooflly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.globooflly.databinding.ActivityDetailBinding
import com.example.globooflly.databinding.ActivitySplashBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Integer.parseInt

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
//    val service  = DeestinationRetrofit.getService(DestinationServices::class.java)
//    var id:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setSupportActionBar(binding.detailToolbar)
//
//
//        intent = getIntent()
//        id = intent.getStringExtra("thisId")
//
//        binding.serverUpdate.setOnClickListener {
//            id?.let { it1 -> updateData(it1) }
//
//        }
//        viewDetailData()
//        binding.serverDelete.setOnClickListener {
//            id?.let { it1 -> deleteDetailData(it1) }
//
//
//        }

    }

//    fun deleteDetailData(id:String){
//        val call = service.deleteDestination(id)
//        call.enqueue(object :Callback<Unit>{
//            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
//                finish()
//                Toast.makeText(this@DetailActivity , "delete successfully" , Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<Unit>, t: Throwable) {
//                Toast.makeText(this@DetailActivity , t.message.toString() , Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
//
//    fun viewDetailData(){
//        val call = service.getDestinationsByID(id.toString())
//        call.enqueue(object :Callback<DestinationModel>{
//            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
//                if(response.isSuccessful){
//                    binding.detailToolbar.title = response.body()?.city
//                    binding.serverCityName.editText?.setText(response.body()?.city )
//                    binding.serverCountryName.editText?.setText(response.body()?.country  )
//                    binding.serverDescription.editText?.setText(response.body()?.description  )
//
//
//                }
//            }
//
//            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//    }
//
//    fun updateData(id_p:String){
//        val services = DeestinationRetrofit.getService(DestinationServices::class.java)
//        val call = services.updateDestination(
//            id_p ,
//            binding.serverCityName.editText?.text.toString(),
//            binding.serverCountryName.editText?.text.toString(),
//            binding.serverDescription.editText?.text.toString()
//            )
//        call.enqueue(object :Callback<DestinationModel>{
//            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
//                if(response.isSuccessful){
//                    binding.detailToolbar.title = response.body()?.city
//                    finish()
//                    Toast.makeText(this@DetailActivity , "post updated sussefully " , Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
//                Toast.makeText(this@DetailActivity ,  t.message.toString() ,Toast.LENGTH_LONG).show()
//            }
//        })
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        //viewDetailData()
//    }
}