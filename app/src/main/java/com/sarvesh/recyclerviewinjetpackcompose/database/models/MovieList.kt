package com.sarvesh.recyclerviewinjetpackcompose.database.models

data class MoviesList(
    val movies: List<Movies>
)

data class Movies(
    val actors: List<CastList>,
    val category: String,
    val cover_image_url: String,
    val genre: List<String>,
    val imdb_rating: Double,
    val language: String,
    val length: String,
    val name: String,
    val popularity: String,
    val short_description: String,
    val trailer_url: String
)

data class CastList(
    val image_url: String,
    val name: String
)