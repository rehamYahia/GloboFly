package com.example.globooflly.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.globooflly.model.DestinationModel
import kotlinx.coroutines.flow.StateFlow

@Dao
public interface DestinationDao {


    @Insert
    fun insertPlace(destinationModel: DestinationModel)

    @Query("SELECT * FROM tableDestination")
    fun getAllPlaces():StateFlow<ArrayList<DestinationModel>>

    @Query("UPDATE tableDestination SET(city =:city_text ,description =:description_text , country =:country_text)WHERE id =:id_text  ")
    fun updatePlace(id_text:String , city_text:String , description_text :String , country_text:String)

    @Query("DELETE FROM tableDestination WHERE id =:id_text")
    fun deletePlace(id_text:String) :Unit

}