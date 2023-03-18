package com.reno.cachetestapp

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit


/**
 * okhttpclient 에 cache 를 추가함으로써 로컬 캐시를 구현
 * */
const val cacheSize = 10L * 1024 * 1024 //10MB

val okHttpClient: (Context) -> OkHttpClient = { context ->
    OkHttpClient.Builder()
        .cache(Cache(context.cacheDir, cacheSize))
        .addInterceptor(CacheControlInterceptor())
        .build()
}

val postManService: (context: Context) -> PostManService = { context ->
    Retrofit.Builder()
        .baseUrl(PostManService.BASE_URL)
        .client(okHttpClient(context))
        .build()
        .create(PostManService::class.java)
}