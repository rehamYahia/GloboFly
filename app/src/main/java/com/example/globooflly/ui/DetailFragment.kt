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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.globooflly.databinding.FragmentDetailBinding
import com.example.globooflly.network.DestinationServices
import com.example.globooflly.retrofit.DeestinationRetrofit
import com.example.globooflly.viewmodel.DestinationViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {

    private  var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!

    val args : DetailFragmentArgs by navArgs()
    var id:String?=null
    private lateinit var navController: NavController
    private val destinationViewModel :DestinationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
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

    private fun updateData(id:String){
        destinationViewModel.updateDestination(
            id ,
            binding.serverCityName.editText?.text.toString(),
            binding.serverCountryName.editText?.text.toString(),
            binding.serverDescription.editText?.text.toString()
        ).observe(viewLifecycleOwner , Observer {list->
            if(list != null)
            {
                Toast.makeText(activity , "post updated sussefully " , Toast.LENGTH_LONG).show()
                //broblem---------------------
                binding.detailToolbar.title = list.city
                //broblem---------------------
                val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                navController.navigate(action)
            }

        })
    }

    //problem--------------
    fun viewDetailData(){
        destinationViewModel.ViewDetailModel(id!!).observe(viewLifecycleOwner , Observer{data->
            if(data!= null){
                //broblem---------------------
                binding.detailToolbar.title = data.country
                //broblem---------------------
                binding.serverCityName.editText?.setText(data.city)
                binding.serverCountryName.editText?.setText( data.country)
                binding.serverDescription.editText?.setText(data.description  )
            }
        })
    }

    fun deleteDetailData(id:String){
        destinationViewModel.deleteDestination(id).observe(viewLifecycleOwner , Observer{unit->
            if(unit == null){
                val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                navController.navigate(action)
                Toast.makeText(activity , "delete successfully" , Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}