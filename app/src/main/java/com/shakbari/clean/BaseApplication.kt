package com.shakbari.clean

import android.app.Application
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ApplicationComponent

@HiltAndroidApp
@Module
@InstallIn(ApplicationComponent::class)
class BaseApplication : Application() {

}