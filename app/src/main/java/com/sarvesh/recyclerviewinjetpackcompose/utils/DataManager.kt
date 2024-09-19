package com.sarvesh.recyclerviewinjetpackcompose.utils

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.sarvesh.recyclerviewinjetpackcompose.database.models.MoviesList

object DataManager {

    var data = MoviesList(emptyList())
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("movies.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer)
        val gson = Gson()
        data = gson.fromJson(json, MoviesList::class.java)
        isDataLoaded.value = true
    }

}