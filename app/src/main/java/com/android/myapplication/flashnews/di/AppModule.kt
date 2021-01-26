package com.android.myapplication.flashnews.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.android.myapplication.flashnews.R
import com.android.myapplication.flashnews.util.APP_PREFERENCES
import com.android.myapplication.flashnews.util.BASE_URL
import com.android.myapplication.popularmovies.util.LiveDataCallAdapterFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule{


    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application) = application.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)


    @Singleton
    @Provides
    fun provideSharedPrefsEditor(sharedPreferences: SharedPreferences) = sharedPreferences.edit()


    @Singleton
    @Provides
    fun provideRequestOptions()= RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)


    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions) = Glide.with(application)
            .setDefaultRequestOptions(requestOptions)


    @Singleton
    @Provides
    fun provideRetrofitBuilder()=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())



}