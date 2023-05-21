package com.example.globooflly.di

import com.example.globooflly.network.DestinationServices
import com.example.globooflly.repositories.DestinationRepoImpl
import com.example.globooflly.repositories.DestinationRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun ProvideRepo(destinationServices: DestinationServices): DestinationRepositories
    {
        return DestinationRepoImpl(destinationServices)
    }

}