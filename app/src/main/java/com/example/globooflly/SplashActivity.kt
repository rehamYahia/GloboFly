package com.example.globooflly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.globooflly.databinding.ActivitySplashBinding
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        val service = DeestinationRetrofit.getService(DestinationServices::class.java)
//        val call = service.getPromoMessge("http://10.0.2.2:7000/messages")
//        call.enqueue(object : Callback<String>{
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                if(response.isSuccessful){
//                    binding.textFromServer.text  = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//            }
//
//        })
////        binding.serverText.text =
//
//        binding.btnSplash.setOnClickListener{
//            startActivity(Intent(this@SplashActivity , DestinationActivity::class.java))
//            finish()
//        }

    }
}