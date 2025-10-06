package dev.thundercloud.galacticmerchants.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.thundercloud.galacticmerchants.model.serverstatus.ServerStatus
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.MediaType.Companion.toMediaType

private const val BASE_URL = "https://api.spacetraders.io/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
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