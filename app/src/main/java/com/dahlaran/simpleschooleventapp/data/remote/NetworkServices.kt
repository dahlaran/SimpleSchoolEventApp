package com.dahlaran.simpleschooleventapp.data.remote

import com.dahlaran.simpleschooleventapp.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkServices {
    private const val NOMAD_EDUCATION_URL =
        "https://res.cloudinary.com/"
    private const val HTTP_TIME_OUT: Long = 10 // In seconds

    fun generateGsonBuilder(): GsonBuilder {
        return GsonBuilder()
    }

    fun generateOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(HTTP_TIME_OUT, TimeUnit.SECONDS)

        // Only do log when the app is in debug mode
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BASIC
            client.addInterceptor(interceptor)
        }

        return client.build()
    }

    fun provideNomadEducationRetrofit(gsonBuilder: GsonBuilder, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(NOMAD_EDUCATION_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .build()
    }

    fun provideNomadEducationServices(): NomadEducationApi {
        return provideNomadEducationRetrofit(generateGsonBuilder(), generateOkHttpClient())
            .create(NomadEducationApi::class.java)
    }
}