package com.it342.mobile.network

import com.it342.mobile.model.AuthResponse
import com.it342.mobile.model.LoginRequest
import com.it342.mobile.model.RegisterRequest
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("/api/auth/logout")
    suspend fun logout(@Header("Authorization") token: String): Response<Void>
}

object RetrofitInstance {
    // Use 10.0.2.2 to point to your computer's localhost from the emulator
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}