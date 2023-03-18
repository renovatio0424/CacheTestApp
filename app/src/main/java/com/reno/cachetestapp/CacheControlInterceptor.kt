package com.reno.cachetestapp

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.io.IOException


class CacheControlInterceptor : Interceptor {
    private val cacheControlMaxAgeValue
        get() = "max-age=$CACHE_CONTROL_MAX_AGE"

    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .header(HTTP_HEADER_KEY_CACHE_CONTROL, cacheControlMaxAgeValue)
            .build()
        return chain.proceed(request)
    }

    companion object {
        private const val HTTP_HEADER_KEY_CACHE_CONTROL = "Cache-Control"
        private const val CACHE_CONTROL_MAX_AGE = 60
    }
}