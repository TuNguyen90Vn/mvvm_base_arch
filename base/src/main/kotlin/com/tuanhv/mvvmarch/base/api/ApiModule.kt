package com.tuanhv.mvvmarch.base.api

import android.content.Context
import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import com.tuanhv.mvvmarch.base.BuildConfig
import com.tuanhv.mvvmarch.base.R
import com.tuanhv.mvvmarch.base.api.user.UserApi
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@Module
class ApiModule {

    companion object {
        const val CACHE_SIZE: Long = 10 * 1024 * 1024
        const val CACHE_TIME_SEC = 30
        const val TIME_OUT: Long = 60
    }

    private val cacheInterceptor: Interceptor
        get() = Interceptor {
            val response = it.proceed(it.request())
            val cacheControl = CacheControl.Builder()
                    .maxAge(CACHE_TIME_SEC, TimeUnit.SECONDS)
                    .build()

            response.newBuilder()
                    .header("Cache-Control", cacheControl.toString())
                    .build()
        }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("Retrofit", message) })
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
            context: Context,
            loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val cache = Cache(File(context.cacheDir, "http-cache"), CACHE_SIZE)
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(cacheInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .cache(cache)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .build()
    }

    @Provides
    @Singleton
    fun provideRestAdapter(
            context: Context,
            okHttpClient: OkHttpClient,
            moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(context.getString(R.string.api_end_point))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(restAdapter: Retrofit): UserApi {
        return restAdapter.create(UserApi::class.java)
    }

}
