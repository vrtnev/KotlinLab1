package com.example.lab1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





public class NetworkService {
    private var mInstance: NetworkService? = null

    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private var mRetrofit: Retrofit? = null

    fun getInstance(): NetworkService {
        if (mInstance == null) {
            mInstance = NetworkService()
        }
        return mInstance as NetworkService
    }
}