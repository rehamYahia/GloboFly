package com.example.globooflly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globooflly.adapter.CountryAdapter
import com.example.globooflly.databinding.ActivityHomeBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
//    var DeList:List<DestinationModel>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        binding.floatingBtn.setOnClickListener {
//            val intent = Intent(this@HomeActivity , AddNewDestinationActivity::class.java)
////            intent.putExtra("listSize" ,DeList?.size )
//            startActivity(intent)
//        }


    }

//    override fun onResume() {
//        super.onResume()
//        initCountryRecycle()
//    }
//    fun initCountryRecycle() {
//
////        val filter :HashMap<String , String> = HashMap()
////        filter["country"]= "Japan"
////        filter["city"]="Tokyo"
//        val service = DeestinationRetrofit.getService(DestinationServices::class.java)
//        service.getAllDestinations().enqueue(object : Callback<List<DestinationModel>> {
//            override fun onResponse(call: Call<List<DestinationModel>>, response: Response<List<DestinationModel>>) {
//             if(response.isSuccessful){
//                 DeList = response.body()
//                 binding.recycleCountry.adapter = CountryAdapter(DeList)
//             }
//
//            }
//
//            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
////                Toast.makeText(this@HomeActivity ,t.message , Toast.LENGTH_LONG ).show()
//                binding.error.text = t.message
//            }
//
//        })
//        binding.recycleCountry.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
//
//    }
}