package com.example.globooflly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.globooflly.databinding.FragmentDetailBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val service  = DeestinationRetrofit.getService(DestinationServices::class.java)
    var id:String?=null
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        val view = binding.root
//        setSupportActionBar(binding.detailToolbar)
        (activity as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
        id = arguments?.getString("thisId")
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDetailData()

        binding.serverUpdate.setOnClickListener {
            id?.let { it1 -> updateData(it1) }

        }
        viewDetailData()
        binding.serverDelete.setOnClickListener {
            id?.let { it1 -> deleteDetailData(it1) }


        }
    }

    //functions

    fun updateData(id_p:String){
        val services = DeestinationRetrofit.getService(DestinationServices::class.java)
        val call = services.updateDestination(
            id_p ,
            binding.serverCityName.editText?.text.toString(),
            binding.serverCountryName.editText?.text.toString(),
            binding.serverDescription.editText?.text.toString()
        )
        call.enqueue(object : Callback<DestinationModel> {
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    binding.detailToolbar.title = response.body()?.city
                    navController.navigate(R.id.homeFragment)
                   // finish()
                    Toast.makeText(activity , "post updated sussefully " , Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                Toast.makeText(activity ,  t.message.toString() , Toast.LENGTH_LONG).show()
            }
        })

    }

    fun viewDetailData(){
        val call = service.getDestinationsByID(id.toString())
        call.enqueue(object :Callback<DestinationModel>{
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    binding.detailToolbar.title = response.body()?.city
                    binding.serverCityName.editText?.setText(response.body()?.city )
                    binding.serverCountryName.editText?.setText(response.body()?.country  )
                    binding.serverDescription.editText?.setText(response.body()?.description  )


                }
            }

            override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun deleteDetailData(id:String){
        val call = service.deleteDestination(id)
        call.enqueue(object :Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
//                finish()
                navController.navigate(R.id.homeFragment)
                Toast.makeText(activity , "delete successfully" , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(activity , t.message.toString() , Toast.LENGTH_LONG).show()
            }

        })
    }


}