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
import com.example.globooflly.databinding.FragmentAddNewDestinationBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddNewDestinationFragment : Fragment() {
    private  var _binding: FragmentAddNewDestinationBinding?=null
    private val binding get() = _binding!!
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
//        return inflater.inflate(R.layout.fragment_add_new_destination, container, false)
        _binding = FragmentAddNewDestinationBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.addDestinationToolbar)
        binding.serverAddBtn.setOnClickListener{
            val service = DeestinationRetrofit.getService(DestinationServices::class.java)
            val call = service.addDestinationPost(DestinationModel(null ,binding.addCityName.editText?.text.toString() , binding.addDescription.editText?.text.toString() ,binding.addCountryName.editText?.text.toString()))
            call.enqueue(object : Callback<DestinationModel> {
                override fun onResponse(call: Call<DestinationModel>, response: Response<DestinationModel>) {
                    if(response.isSuccessful){
//                        finish()
                        navController.navigate(R.id.homeFragment)
                        Toast.makeText(activity , "post add sussefully " , Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<DestinationModel>, t: Throwable) {
                    Toast.makeText(activity ,  t.message.toString() , Toast.LENGTH_LONG).show()
                }

            })

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}