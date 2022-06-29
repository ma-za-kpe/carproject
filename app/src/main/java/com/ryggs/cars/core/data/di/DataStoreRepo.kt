package com.ryggs.cars.core.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

const val MY_PREFERENCES_NAME = "CARS"
const val PREFERENCES_CAR_ID = "CAR_ID"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = MY_PREFERENCES_NAME)

@ActivityRetainedScoped
class DataStoreRepo @Inject constructor(@ApplicationContext private val context: Context) {

    private object PreferenceKeys {
        val carId = stringPreferencesKey(PREFERENCES_CAR_ID)
    }

    // capacity
    suspend fun saveCarId(
        id: String,
    ) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.carId] = id
        }
    }

    val readCarId: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }
        }
        .map { preferences ->
            val carId = preferences[PreferenceKeys.carId] ?: PREFERENCES_CAR_ID
            carId
        }
}