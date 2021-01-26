package com.android.myapplication.flashnews.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.android.myapplication.flashnews.R
import com.android.myapplication.flashnews.models.Article
import com.android.myapplication.flashnews.persistence.ArticleDb

fun String.formatStringDate() = this.removeRange(this.indexOf("T") until this.length)
fun SharedPreferences.getCountry() = getString(ARTICLE_COUNTRY_KEY, AUSTRALIA)?: AUSTRALIA
fun SharedPreferences.getCategory() = getString(ARTICLE_CATEGORY_KEY, GENERAL) ?: GENERAL
fun SharedPreferences.getSourceID() = getString(ARTICLE_SOURCE_ID_KEY, GENERAL)!!
fun SharedPreferences.Editor.saveCountryAndCategory(country: String, category: String) {
    putString(ARTICLE_COUNTRY_KEY, country)
    putString(ARTICLE_CATEGORY_KEY, category)
    apply()
}

fun isNetworkError(msg: String) = msg.contains(UNABLE_TO_RESOLVE_HOST)

fun Application.isNetworkAvailable() = try {
    (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo.isConnected
} catch (e: Exception) {
    Log.e(TAG, "isConnectedToTheInternet: ${e.message}")
    false
}


fun Context.displayToast(@StringRes message: Int) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Context.displayToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
fun Context.displaySuccessDialog(message: String?) = MaterialDialog(this)
    .show {
        title(R.string.text_success)
        message(text = message)
        positiveButton(R.string.text_ok)
    }

fun Context.displayErrorDialog(errorMessage: String?) = MaterialDialog(this)
    .show {
        title(R.string.text_error)
        message(text = errorMessage)
        positiveButton(R.string.text_ok)
    }

fun ProgressBar.load(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

fun convertArticleUItoDB(article: Article) = with(article) {
    ArticleDb(
        title = title,
        author = author,
        description = description,
        url =url,
        urlToImage = urlToImage,
        publishDate = publishDate,
        content = content,
        source = source,
        isFavorite = isFavorite
    )
}

fun convertArticleDBtoUI(articleDB: ArticleDb) = with(articleDB) {
    Article(
        title,
        author,
        description,
        url,
        urlToImage,
        publishDate,
        content,
        source,
        isFavorite
    )
}

fun List<Article>.findCommonAndReplace(article: Article) = map{if(it==article) article else it  }