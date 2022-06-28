package com.ryggs.cars.core.data.di

import com.ryggs.cars.core.data.repository.CarRepository
import com.ryggs.cars.core.data.repository.CarRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {

  @Binds
  @ActivityRetainedScoped
  abstract fun bindCarRepository(repository: CarRepositoryImpl): CarRepository

  companion object {
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
  }
}