package com.assignment.kotlinmvvm.interfaces

import FlightStatusData
import TokenData
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.http.*

interface ApiInterface {

    @Headers("Content-Type: application/x-www-form-urlencoded" ,"Accept-Language: en-EN","Accept: application/hal+json;version=com.afkl.operationalflight.v3")
    @GET
    fun getFlightStatus(@Url url: String, @Query("origin") origin: String,
                        @Query("expand") expand: String,@Header("Authorization") auth: String ) : Observable<FlightStatusData>

    @GET("/travel/flightstatus/")
    fun getAllFlightStatus(@Query("origin") origin: String,
                        @Query("destination") destination: String,@Query("startRange") startRange: String,
                           @Query("endRange") endRange: String) : Observable<FlightStatusData>

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded" , "Authorization: Basic ZnJjMjI1Z3l4NWtlenB2NGQ3d3d1Z205OkJnYVhDWGFnZnQ=")
    @POST("/travel/oauth")
    fun getToken(@Field("grant_type") credentials: String) : Observable<TokenData>

}