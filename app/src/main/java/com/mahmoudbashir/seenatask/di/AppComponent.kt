package com.mahmoudbashir.seenatask.di

import android.app.Application
import com.mahmoudbashir.seenatask.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(

)
interface AppComponent : AndroidInjector<MyApp> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    override fun inject(app: MyApp?)
}