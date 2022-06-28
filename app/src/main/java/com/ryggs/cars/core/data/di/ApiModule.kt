package com.ryggs.cars.core.data.di

import com.ryggs.cars.core.data.remote.ApiConstants
import com.ryggs.cars.core.data.remote.CarsApi
import com.ryggs.cars.core.data.remote.interceptors.LoggingInterceptor
import com.ryggs.cars.core.data.remote.interceptors.NetworkStatusInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

  @Provides
  @Singleton
  fun provideApi(builder: Retrofit.Builder): CarsApi {
    return builder
        .build()
        .create(CarsApi::class.java)
  }

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_ENDPOINT)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
  }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        networkStatusInterceptor: NetworkStatusInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkStatusInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    @Provides
  fun provideHttpLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(loggingInterceptor)

    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return interceptor
  }
}