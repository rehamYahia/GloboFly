package com.example.globooflly

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globooflly.adapter.CountryAdapter
import com.example.globooflly.databinding.FragmentHomeBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navControler:NavController
    var DeList:List<DestinationModel>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        initCountryRecycle()
        navControler = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingBtn.setOnClickListener {
            navControler.navigate(R.id.addNewDestinationFragment)
        }
    }

    fun initCountryRecycle() {


        val service = DeestinationRetrofit.getService(DestinationServices::class.java)
        service.getAllDestinations().enqueue(object : Callback<List<DestinationModel>> {
            override fun onResponse(call: Call<List<DestinationModel>>, response: Response<List<DestinationModel>>) {
                if(response.isSuccessful){
                    DeList = response.body()
                    binding.recycleCountry.adapter = CountryAdapter(DeList)
                }

            }

            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
//                Toast.makeText(this@HomeActivity ,t.message , Toast.LENGTH_LONG ).show()
                binding.error.text = t.message
            }

        })
        binding.recycleCountry.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initCountryRecycle()
    }


}