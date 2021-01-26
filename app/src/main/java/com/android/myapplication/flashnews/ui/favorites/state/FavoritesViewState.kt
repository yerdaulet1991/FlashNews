package com.android.myapplication.flashnews.ui.headlines.state

import com.android.myapplication.flashnews.models.Article

data class FavoritesViewState(
    val favoritesFields: FavoritesFields = FavoritesFields()
) {
     class FavoritesFields(
         var favoritesList: List<Article> = ArrayList<Article>(),
         var emptyFavoritesScreen: String = ""
    )
}