package com.example.globooflly.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
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
import com.example.globooflly.receiver.ConnectivityReceiver
import com.example.globooflly.viewmodel.DestinationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AddNewDestinationFragment : Fragment() //, ConnectivityReceiver.ConnectivityReceiverListener
{
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
   //To obtain information about the current state of the connection
//        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork:NetworkInfo? = cm.activeNetworkInfo
//        val isConnected : Boolean = activeNetwork?.isConnected == true
//
//        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
//        ConnectivityReceiver.connectivityReceiverListener = this

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

//    override fun onNetworkConnectionChanged(isConnected: Boolean) {
//        showNetworkMessage(isConnected)
//    }


//    private fun showNetworkMessage(isConnected: Boolean) {
//        if (!isConnected) {
//            //snackbar = Snackbar.make(findViewById(R.id.rootLayout), "You are offline", Snackbar.LENGTH_LONG) //Assume "rootLayout" as the root layout of every activity.
//            //snackbar?.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
//           // snackbar?.show()
//        } else {
//            //snackbar?.dismiss()
//        }
//    }


}