package com.anncode.offersandcoupons.model

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiAdapter {
    //Consulta a las APIS
    val apiKey = "d7c219d2c3486f5e8135d2c93c52c280"
    val urlApi = "http://feed.linkmydeals.com/"

    fun getClientService(): ApiService {
        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("API_KEY", apiKey)
                .addQueryParameter("format", "json")
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()
            Log.d("URL_IMPRESA",url.url().toString())
            chain.proceed(newRequest)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit.create(ApiService::class.java)
    }

}