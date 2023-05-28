package com.example.globooflly.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.globooflly.databinding.FragmentAddNewDestinationBinding
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.viewmodel.DestinationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


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
            if(binding.addCityName.editText?.text?.trim().toString().isNotEmpty() && binding.addDescription.editText?.text.toString().isNotEmpty() && binding.addCountryName.editText?.text.toString().isNotEmpty() ){
                destinationViewModel.AddNewDestination(DestinationModel(null ,binding.addCityName.editText?.text.toString() , binding.addDescription.editText?.text.toString() ,binding.addCountryName.editText?.text.toString() ))

                lifecycleScope.launch {
                    destinationViewModel.addDestination.collect{
                        Toast.makeText(activity , "post add sussefully " , Toast.LENGTH_LONG).show()
                    }
                }
                val action = AddNewDestinationFragmentDirections.actionAddNewDestinationFragmentToHomeFragment()
                navController.navigate(action)
            }else{
                Toast.makeText(activity , "Please enter destination " , Toast.LENGTH_LONG).show()
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}