package com.example.globooflly.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globooflly.DetailActivity
import com.example.globooflly.R
import com.example.globooflly.model.DestinationModel
import java.util.*

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    var countryList :List <DestinationModel> = ArrayList()


    constructor(list: List<DestinationModel>?){
        if (list != null) {
            countryList = list
        }
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
        holder.cuntry.text = countryList.get(position).country
        holder.itemView.setOnClickListener{it->
            val context = it.context
            val intent = Intent(context , DetailActivity::class.java)
            intent.putExtra("thisId",countryList.get(position).id)
            context.startActivity(intent)
        }
    }
}