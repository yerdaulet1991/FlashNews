package com.android.myapplication.flashnews.di

import android.app.Application
import com.android.myapplication.flashnews.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules=[
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuildersModule::class,
    ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}