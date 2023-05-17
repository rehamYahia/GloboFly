package com.example.globooflly

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private  var _binding: FragmentHomeBinding?=null
    private val binding get()= _binding!!

    private lateinit var navControler:NavController
    var DeList:List<DestinationModel>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCountryRecycle()
        binding.floatingBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddNewDestinationFragment()
            navControler.navigate(action)
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
                Toast.makeText(activity ,t.message , Toast.LENGTH_LONG ).show()
//                binding.error.text = t.message
            }

        })
        binding.recycleCountry.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        initCountryRecycle()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}