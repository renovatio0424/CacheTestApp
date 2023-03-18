package com.reno.cachetestapp

import retrofit2.http.GET
import retrofit2.http.Headers

interface PostManService {
    @GET("/cacheTest")
    suspend fun getCacheTest()

    @Headers("Cache-Control: max-age=5")
    @GET("/requestCache")
    suspend fun getRequestCache()

    companion object {
        const val BASE_URL = BuildConfig.BASE_URL
    }
}
