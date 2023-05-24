package com.example.globooflly.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.globooflly.databinding.FragmentAddNewDestinationBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.viewmodel.DestinationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class AddNewDestinationFragment : Fragment() {
    private  var _binding: FragmentAddNewDestinationBinding?=null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val destinationViewModel : DestinationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewDestinationBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.addDestinationToolbar)
        binding.serverAddBtn.setOnClickListener{
            destinationViewModel.AddNewDestination(DestinationModel(null ,binding.addCityName.editText?.text.toString() , binding.addDescription.editText?.text.toString() ,binding.addCountryName.editText?.text.toString() ))
            lifecycleScope.launch {
                destinationViewModel.addDestination.collect{
                    val action = AddNewDestinationFragmentDirections.actionAddNewDestinationFragmentToHomeFragment()
                        navController.navigate(action)
                        Toast.makeText(activity , "post add sussefully " , Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}