package com.example.globooflly.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast


class ConnectivityReceiver//: BroadcastReceiver()
{

//    override fun onReceive(context: Context?, intent: Intent?) {
//
//        if (connectivityReceiverListener != null) {
//            connectivityReceiverListener!!.onNetworkConnectionChanged(isConnectedOrConnecting(context!!))
//        }
//
//    }
//
//    private fun isConnectedOrConnecting(context: Context): Boolean {
//        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val networkInfo = connMgr.activeNetworkInfo
//        return networkInfo != null && networkInfo.isConnectedOrConnecting
//    }
//
//    interface ConnectivityReceiverListener {
//        fun onNetworkConnectionChanged(isConnected: Boolean)
//    }
//
//    companion object {
//        var connectivityReceiverListener: ConnectivityReceiverListener? = null
//    }
}



//class ConnectivityReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        //To obtain information about the current state of the connection
//        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//        val isConnected : Boolean = activeNetwork?.isConnected == true
//        Toast.makeText(context , if(isConnected) "connection present" else "No internet connection", Toast.LENGTH_LONG).show()
//    }
//
//}


