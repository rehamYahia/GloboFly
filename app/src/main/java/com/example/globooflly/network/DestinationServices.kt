package com.example.globooflly.network

import com.example.globooflly.model.DestinationModel
import retrofit2.Call
import retrofit2.http.*

interface DestinationServices {
    @GET("destination")
    fun getAllDestinations():Call<List<DestinationModel>>

    //using query parameter
//    @GET("destination")
//    fun getAllDestinations(@Query("country") country: String? , @Query("city") city:String?):Call<List<DestinationModel>>

    //using queryMap parameter
//    @GET("destination")
//    fun getAllDestinations(@QueryMap filter :HashMap<String , String>):Call<List<DestinationModel>>

//    @GET("messages")
//    fun getPromoMessge():Call<String>


    //run with another server
    @GET
    fun getPromoMessge(@Url url:String):Call<String>


    //using path parameter
    @GET("destination/{id}")
    fun getDestinationsByID(@Path("id") id:String):Call<DestinationModel>

    @POST("destination")
    fun addDestinationPost(@Body destinationModel:DestinationModel):Call<DestinationModel>

    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id") id:String,
        @Field("city")city:String,
        @Field("country") country:String,
        @Field("description") description:String
    ):Call<DestinationModel>

    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id")id:String):Call<Unit>
}