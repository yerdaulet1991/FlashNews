package com.android.myapplication.flashnews.api.responses

import com.android.myapplication.flashnews.api.data.ArticleNetwork
import com.google.gson.annotations.SerializedName

class HeadlinesResponse(
    @SerializedName("articles")
    var articlesNetwork: List<ArticleNetwork>?=null,
    @SerializedName("status")
    var status: String,
    @SerializedName("code")
    var code: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("totalResults")
    var totalResults: Int
) {

}