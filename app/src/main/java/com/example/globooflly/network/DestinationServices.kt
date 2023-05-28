package com.example.globooflly.network

import com.example.globooflly.model.DestinationModel
import retrofit2.Call
import retrofit2.http.*

interface DestinationServices {
    @GET("destination")
   suspend fun getAllDestinations():ArrayList<DestinationModel>

    //using query parameter
//    @GET("destination")
//    fun getAllDestinations(@Query("country") country: String? , @Query("city") city:String?):Call<List<DestinationModel>>

    //using queryMap parameter
//    @GET("destination")
//    fun getAllDestinations(@QueryMap filter :HashMap<String , String>):Call<List<DestinationModel>>

    @GET("messages")
    suspend fun getPromoMessge():String


    //run with another server
//    @GET
//    fun getPromoMessge(@Url url:String):Call<String>


    //using path parameter
    @GET("destination/{id}")
    suspend fun getDestinationsByID(@Path("id") id:String):DestinationModel

    @POST("destination")
    suspend fun addDestinationPost(@Body destinationModel:DestinationModel):DestinationModel

    @FormUrlEncoded
    @PUT("destination/{id}")
    suspend fun updateDestination(
        @Path("id") id:String,
        @Field("city")city:String,
        @Field("country") country:String,
        @Field("description") description:String
    ):DestinationModel

    @DELETE("destination/{id}")
    suspend fun deleteDestination(@Path("id")id:String):Unit
}