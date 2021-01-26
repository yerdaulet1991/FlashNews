package com.android.myapplication.flashnews.ui.sources.state

import com.android.myapplication.flashnews.models.Article
import com.android.myapplication.flashnews.models.Source

class SourcesViewState(
    val sourcesField: SourcesField = SourcesField(),
    val articlesSourceField: ArticlesSourceField = ArticlesSourceField()
) {
    class SourcesField(
        var sourceList: List<Source> = ArrayList<Source>(),
        var errorScreenMsg: String = ""
    )

    class ArticlesSourceField(
        var articleList: List<Article> = ArrayList<Article>(),
        var errorScreenMsg: String = "",
        var isQueryExhausted: Boolean = false,
        var sourceId: String = "",
        var sourceName:String = "",
        var page: Int = 1,
        var isQueryInProgress: Boolean = false
    )
}