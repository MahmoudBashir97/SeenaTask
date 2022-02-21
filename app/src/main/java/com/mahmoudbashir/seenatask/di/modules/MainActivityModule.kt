package com.mahmoudbashir.seenatask.di.modules

import com.mahmoudbashir.seenatask.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class,
            AppModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}