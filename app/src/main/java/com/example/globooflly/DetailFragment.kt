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
import androidx.navigation.fragment.navArgs
import com.example.globooflly.databinding.FragmentDetailBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {

    private  var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    val service  = DeestinationRetrofit.getService(DestinationServices::class.java)
    val args : DetailFragmentArgs  by navArgs()
    var id:String?=null
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
//        id = arguments?.getString("id")

        id = args.listId
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
//        val services = DeestinationRetrofit.getService(DestinationServices::class.java)
        val call = service.updateDestination(
            id_p ,
            binding.serverCityName.editText?.text.toString(),
            binding.serverCountryName.editText?.text.toString(),
            binding.serverDescription.editText?.text.toString()
        )
        call.enqueue(object : Callback<DestinationModel> {
            override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                if(response.isSuccessful){
                    binding.detailToolbar.title = response.body()?.city
                    val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                    navController.navigate(action)
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
                val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                navController.navigate(action)
                Toast.makeText(activity , "delete successfully" , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(activity , t.message.toString() , Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}