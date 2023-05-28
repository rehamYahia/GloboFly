package com.example.globooflly.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.globooflly.model.DestinationModel

@Database(entities = DestinationModel::class.java , version = 1  , exportSchema = false)
abstract class DestinationDatabase : RoomDatabase() {

    abstract fun  DesDao():DestinationDao
}