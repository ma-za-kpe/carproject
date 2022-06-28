package com.ryggs.cars.core.data.di

import android.content.Context
import androidx.room.Room
import com.ryggs.cars.core.data.cache.CarCache
import com.ryggs.cars.core.data.cache.CarCacheImpl
import com.ryggs.cars.core.data.cache.CarDatabase
import com.ryggs.cars.core.data.cache.dao.CarDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

  @Binds
  abstract fun bindCache(cache: CarCacheImpl): CarCache

  companion object {

      @Provides
      @Singleton
      fun provideDatabase(
          @ApplicationContext context: Context
      ): CarDatabase {
          return Room.databaseBuilder(
              context,
              CarDatabase::class.java,
              "car.db"
          ).build()
      }

      @Provides
      fun provideCarDao(
          carDatabase: CarDatabase
      ): CarDao = carDatabase.carDao()
  }
}