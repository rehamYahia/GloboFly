package com.example.globooflly.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.globooflly.databinding.FragmentSplashBinding
import com.example.globooflly.viewmodel.DestinationViewModel



class SplashFragment : Fragment() {
    private  var _binding: FragmentSplashBinding?=null
    private val binding get() = _binding!!
//    private lateinit var binding :FragmentSplashBinding
    private lateinit var navControler: NavController
    val destinationViewModel : DestinationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        destinationViewModel.getPromoData().observe( viewLifecycleOwner, Observer {promo->
            binding.textFromServer.text = promo
        })

        binding.btnSplash.setOnClickListener{

            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            navControler.navigate(action)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}