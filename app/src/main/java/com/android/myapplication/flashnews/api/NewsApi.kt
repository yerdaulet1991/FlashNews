package com.android.myapplication.flashnews.api

import androidx.lifecycle.LiveData
import com.android.myapplication.flashnews.BuildConfig
import com.android.myapplication.flashnews.api.responses.HeadlinesResponse
import com.android.myapplication.flashnews.api.responses.SourcesResponse
import com.android.myapplication.flashnews.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String? = "us",
        @Query("category") category: String = "general",
        @Query("page") page: Int = 1,
        @Query("q") searchQuery:String ="",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): LiveData<GenericApiResponse<HeadlinesResponse>>
    @GET("v2/top-headlines")
    fun getTopHeadlinesBySource(
        @Query("sources") sourcesId: String,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): LiveData<GenericApiResponse<HeadlinesResponse>>

    @GET("v2/sources")
    fun getSources(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = "en"
        ): LiveData<GenericApiResponse<SourcesResponse>>
}
