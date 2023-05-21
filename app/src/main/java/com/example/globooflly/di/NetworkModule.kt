package com.example.globooflly.di

import com.example.globooflly.network.DestinationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://10.0.2.2:9000/"

    @Provides
    @Singleton
    fun provideOkHttp ():OkHttpClient
    {
        return OkHttpClient.Builder()
            .connectTimeout(20 , TimeUnit.SECONDS)
            .readTimeout(20 , TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit):DestinationServices
    {
        return retrofit.create(DestinationServices::class.java)
    }
}