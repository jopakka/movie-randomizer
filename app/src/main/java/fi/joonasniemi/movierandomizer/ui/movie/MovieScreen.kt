package fi.joonasniemi.movierandomizer.ui.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MovieScreen(
    movieViewModel: MovieViewModel = viewModel(
        factory = MovieViewModelFactory("max payne")
    ),
) {
    val loading by movieViewModel.loading.collectAsState()
    val movie by movieViewModel.movie.collectAsState()

    Scaffold(modifier = Modifier.fillMaxWidth()) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if(loading) {
                CircularProgressIndicator()
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