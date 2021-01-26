package com.android.myapplication.flashnews.api.responses

import com.android.myapplication.flashnews.api.data.SourceNetwork
import com.google.gson.annotations.SerializedName

class SourcesResponse (
    @SerializedName("sources")
    val sourcesNetwork:List<SourceNetwork>?=null
)