package com.android.myapplication.flashnews.ui.sources.categories

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.android.myapplication.flashnews.R
import com.android.myapplication.flashnews.models.Source
import com.android.myapplication.flashnews.util.BUSINESS

/**
 * A simple [Fragment] subclass.
 */
class BusinessFragment : BaseCategoriesFragment() {

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): View =inflater.inflate(R.layout.fragment_business,container,false)

    override fun findRV(view:View): RecyclerView = view.findViewById(R.id.rv_business)

    override fun filterSourceList(sourceList: List<Source>): List<Source>  = sourceList.filter { source ->
        source.category.equals(BUSINESS)
    }

}
