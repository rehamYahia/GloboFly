package com.example.globooflly.di

import android.app.Application
import androidx.room.Room
import com.example.globooflly.database.DestinationDao
import com.example.globooflly.database.DestinationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase (application: Application):DestinationDatabase{
        return Room.databaseBuilder(application ,DestinationDatabase::class.java , "destination_DB" )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    }

    @Provides
    @Singleton
    fun provideDao(destinationDatabase: DestinationDatabase):DestinationDao{
        return destinationDatabase.DesDao()
    }
}