package com.android.myapplication.flashnews.di

import com.android.myapplication.flashnews.di.main.MainFragmentBuildersModule
import com.android.myapplication.flashnews.di.main.MainModule
import com.android.myapplication.flashnews.di.main.MainScope
import com.android.myapplication.flashnews.di.main.MainViewModelModule
import com.android.myapplication.flashnews.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class, MainFragmentBuildersModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}