package com.sarvesh.recyclerviewinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sarvesh.recyclerviewinjetpackcompose.ui.view.MoviesListScreen
import com.sarvesh.recyclerviewinjetpackcompose.utils.DataManager
import com.sarvesh.recyclerviewinjetpackcompose.ui.theme.RecyclerViewInJetPackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(this@MainActivity)
        }
        setContent {
            RecyclerViewInJetPackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        MoviesListScreen(data = DataManager.data.movies)
    }
}