package com.reno.cachetestapp

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET

interface PostManService {
    @GET("/cacheTest")
    suspend fun getCacheTest()

    companion object {
        const val BASE_URL = BuildConfig.BASE_URL
    }
}

const val cacheSize = 10L * 1024 * 1024 //10MB

val okHttpClient: (Context) -> OkHttpClient = { context ->
    OkHttpClient.Builder()
        .cache(Cache(context.cacheDir, cacheSize))
        .build()
}

val postManService: (context: Context) -> PostManService = { context ->
    Retrofit.Builder()
        .baseUrl(PostManService.BASE_URL)
        .client(okHttpClient(context))
        .build()
        .create(PostManService::class.java)
}