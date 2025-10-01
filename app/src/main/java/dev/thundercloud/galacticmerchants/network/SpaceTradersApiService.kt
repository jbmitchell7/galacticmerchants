package dev.thundercloud.galacticmerchants.network

import dev.thundercloud.galacticmerchants.model.ServerStatus
import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.spacetraders.io/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SpaceTradersApiService {
    @GET(".")
    suspend fun getServerStatus(): ServerStatus
//    @POST("register")
//    suspend fun registerAgent(@Body callsign: String, faction: String)
}

object SpaceTradersApi {
    val retrofitService : SpaceTradersApiService by lazy {
        retrofit.create(SpaceTradersApiService::class.java)
    }
}