package fi.joonasniemi.movierandomizer.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.movierandomizer.data.Movie

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies) { movie ->
            MovieListItem(movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieList() {
    Column(modifier = Modifier.fillMaxWidth()) {
        val movies = listOf(
            Movie("Home Alone 1"),
            Movie("Home Alone 2"),
            Movie("Home Alone 3"),
            Movie("Home Alone 4"),
        )
        MovieList(movies)
    }
}