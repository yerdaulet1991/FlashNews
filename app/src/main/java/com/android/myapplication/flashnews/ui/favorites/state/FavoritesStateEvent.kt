package com.android.myapplication.flashnews.ui.headlines.state

import com.android.myapplication.flashnews.models.Article

sealed class FavoritesStateEvent {
    class GetFavoritesEvent(
    ) : FavoritesStateEvent()

    class None : FavoritesStateEvent()

    class DeleteFromFavEvent(
        val article: Article
    ) : FavoritesStateEvent()
}
