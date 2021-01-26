package com.android.myapplication.flashnews.di.main

import com.android.myapplication.flashnews.ui.favorites.FavoritesFragment
import com.android.myapplication.flashnews.ui.headlines.HeadlineFragment
import com.android.myapplication.flashnews.ui.sources.ArticlesSourceFragment
import com.android.myapplication.flashnews.ui.sources.SourcesFragment
import com.android.myapplication.flashnews.ui.sources.categories.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoritesFragment():FavoritesFragment

    @ContributesAndroidInjector
    abstract fun contributeHeadlineFragment():HeadlineFragment

    @ContributesAndroidInjector
    abstract fun contributeSourcesFragment():SourcesFragment

    @ContributesAndroidInjector
    abstract fun contributeArticlesSourceFragment():ArticlesSourceFragment

    @ContributesAndroidInjector
    abstract fun contributeBusinessFragment():BusinessFragment

    @ContributesAndroidInjector
    abstract fun contributeEntertainmentFragment():EntertainmentFragment

    @ContributesAndroidInjector
    abstract fun contributeGeneralFragment():GeneralFragment

    @ContributesAndroidInjector
    abstract fun contributeHealthFragment():HealthFragment

    @ContributesAndroidInjector
    abstract fun contributeScienceFragment():ScienceFragment

    @ContributesAndroidInjector
    abstract fun contributeSportFragment():SportFragment

    @ContributesAndroidInjector
    abstract fun contributeTechnologyFragment():TechnologyFragment

}