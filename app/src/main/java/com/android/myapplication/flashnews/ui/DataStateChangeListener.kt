package com.android.myapplication.flashnews.ui

interface DataStateChangeListener {
    fun expandAppBar()
    fun onDataStateChange(dataState: DataState<*>?)
    fun hideSoftKeyboard()
}