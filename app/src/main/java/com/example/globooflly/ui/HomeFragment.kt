package com.example.globooflly.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globooflly.adapter.CountryAdapter
import com.example.globooflly.databinding.FragmentHomeBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.viewmodel.DestinationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding?=null
    private val binding get()= _binding!!
    private  var DeList:ArrayList<DestinationModel>?=null
    private val destinationViewModel :DestinationViewModel by viewModels()
    private lateinit var navControler:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navControler = findNavController()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
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

    private fun initCountryRecycle() {

        destinationViewModel.getList()
        lifecycleScope.launch {
            destinationViewModel.listOfCountry.collect{
                DeList = ArrayList()
                DeList = it
                binding.recycleCountry.adapter = CountryAdapter(DeList)
                binding.recycleCountry.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                it?.forEach {
                    destinationViewModel.VinsertPlace(it)
                }

            }
        }
    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }


}