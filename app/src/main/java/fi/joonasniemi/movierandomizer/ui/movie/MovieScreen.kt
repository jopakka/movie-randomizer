package fi.joonasniemi.movierandomizer.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MovieScreen(
    movieViewModel: MovieViewModel = viewModel(
        factory = MovieViewModelFactory("max payne")
    ),
) {
    val loading by movieViewModel.loading.collectAsState()
    val movie by movieViewModel.movie.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            if(loading) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(1f)
                }
                return@Column
            }
            movie?.let {
                Text(
                    text = it.Title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieScreen() {
    MovieScreen()
}