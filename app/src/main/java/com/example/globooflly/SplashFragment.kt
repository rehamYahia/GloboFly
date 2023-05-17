package com.example.globooflly


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.globooflly.databinding.FragmentSplashBinding
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashFragment : Fragment() {
    private  var _binding: FragmentSplashBinding?=null
    private val binding get() = _binding!!
//    private lateinit var binding :FragmentSplashBinding
    private lateinit var navControler: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_splash, container, false)
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = DeestinationRetrofit.getService(DestinationServices::class.java)
        val call = service.getPromoMessge("http://10.0.2.2:7000/messages")
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    binding.textFromServer.text  = response.body()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
            }

        })

        binding.btnSplash.setOnClickListener{
//            navControler.navigate(R.id.homeFragment)
            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            navControler.navigate(action)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}