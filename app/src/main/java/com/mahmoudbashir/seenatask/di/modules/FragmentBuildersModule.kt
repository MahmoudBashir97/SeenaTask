package com.mahmoudbashir.seenatask.di.modules

import com.mahmoudbashir.seenatask.ui.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeImagesListFragment(): HomeFragment

}
