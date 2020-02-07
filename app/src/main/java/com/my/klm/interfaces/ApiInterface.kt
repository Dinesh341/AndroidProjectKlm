package com.assignment.kotlinmvvm.interfaces

import FlightStatusData
import TokenData
import com.google.gson.JsonObject
import com.my.klm.model.route.FlightRouteBase
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.http.*

interface ApiInterface {

    @Headers("Content-Type: application/x-www-form-urlencoded" ,"Accept-Language: en-EN","Accept: application/hal+json;version=com.afkl.operationalflight.v3")
    @GET
    fun getFlightStatus(@Url url: String, @Query("origin") origin: String,
                        @Query("expand") expand: String,@Header("Authorization") auth: String ) : Observable<FlightStatusData>

    @Headers("Accept: application/hal+json;version=com.afkl.operationalflight.v3")
    @GET("/travel/flightstatus/")
    fun getAllRouteFlight(@Query("origin") origin: String,
                        @Query("destination") destination: String,@Query("startRange") startRange: String,
                           @Query("endRange") endRange: String,@Header("Authorization") auth: String ) : Observable<FlightRouteBase>

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded" , "Authorization: Basic ZnJjMjI1Z3l4NWtlenB2NGQ3d3d1Z205OkJnYVhDWGFnZnQ=")
    @POST("/travel/oauth")
    fun getToken(@Field("grant_type") credentials: String) : Observable<TokenData>

}