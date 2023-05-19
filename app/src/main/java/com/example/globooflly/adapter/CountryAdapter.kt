package com.example.globooflly.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.globooflly.R
import com.example.globooflly.model.DestinationModel
import com.example.globooflly.ui.HomeFragmentDirections
import java.util.*
import kotlin.collections.ArrayList

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    var countryList :ArrayList <DestinationModel> = ArrayList()
//    private lateinit var navControler:NavController


    constructor(list: ArrayList<DestinationModel>?){
//        if (list != null) {
//            countryList = list
//        }
        countryList = list!!
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var cuntry : TextView = itemView.findViewById(R.id.countryId)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country , parent , false))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.cuntry.text = countryList[position].country
        holder.itemView.setOnClickListener{
            val data = countryList[position].id
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data!!)
            Navigation.findNavController(it).navigate(action)
        }
    }
}