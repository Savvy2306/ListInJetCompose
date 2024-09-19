package com.sarvesh.recyclerviewinjetpackcompose.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.sarvesh.recyclerviewinjetpackcompose.R
import com.sarvesh.recyclerviewinjetpackcompose.database.models.Movies
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.ContentMulishRegular
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.ContentTextMulishBold
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.HeadingMerriweatherBlack
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.HeadingMulishBold
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.LightLavender
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.SoftBlue
import com.sarvesh.recyclerviewinjetpackcompose.utils.DateTimeUtils

@Composable
fun MoviesListScreen(data: List<Movies>) {
    LazyColumn {
        item {
            Column {
                Text(
                    text = "Popular Movies",
                    style = HeadingMerriweatherBlack.titleMedium,
                    modifier = Modifier.padding(15.dp)
                )
                LazyRow {
                    items(data.filter { it.popularity == "Very High" }) {
                        PopularMovieItem(movie = it)
                    }
                }
                Text(
                    text = "All Movies",
                    style = HeadingMerriweatherBlack.titleMedium,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
        items(data) {
            AllMoviesItem(movie = it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PopularMovieItem(movie: Movies) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        GlideImage(
            model = movie.cover_image_url,
            contentDescription = "Movie Image",
            modifier = Modifier
                .height(180.dp)
                .width(126.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = movie.name,
            style = HeadingMulishBold.titleSmall,
            modifier = Modifier
                .width(126.dp)
                .padding(top = 8.dp),
            softWrap = true
        )
        RatingWithIcon(rating = movie.imdb_rating.toString())
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AllMoviesItem(movie: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        GlideImage(
            model = movie.cover_image_url,
            contentDescription = "Movie Image",
            modifier = Modifier
                .height(120.dp)
                .width(85.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )

        Column(modifier = Modifier.padding(start = 10.dp, top = 8.dp)) {
            Text(text = movie.name, style = HeadingMulishBold.titleSmall, softWrap = true)
            RatingWithIcon(rating = movie.imdb_rating.toString())
            LazyRow(modifier = Modifier.padding(top = 8.dp)) {
                items(movie.genre) {
                    GenreListItem(genre = it)
                }
            }
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Star Icon",
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = DateTimeUtils.convertMinutesToHoursAndMinutes(
                        movie.length.trim().toInt()
                    ), style = ContentTextMulishBold.titleMedium, color = Color.Black
                )
            }
        }
    }
}

@Composable
fun GenreListItem(genre: String) {
    Card(
        modifier = Modifier.padding(end = 8.dp),
        colors = CardDefaults.cardColors(LightLavender),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = genre,
            modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp, end = 12.dp),
            color = SoftBlue,
            style = ContentMulishRegular.titleSmall
        )
    }
}

@Composable
fun RatingWithIcon(rating: String) {
    Row(
        modifier = Modifier.padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "Star Icon",
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "$rating / 10 IMDb", style = ContentTextMulishBold.titleMedium
        )
    }
}