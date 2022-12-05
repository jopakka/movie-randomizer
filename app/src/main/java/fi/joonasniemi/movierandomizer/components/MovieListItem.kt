package fi.joonasniemi.movierandomizer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.movierandomizer.data.Movie

@Composable
fun MovieListItem(movie: Movie) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Column {
                Text(movie.title)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieListItem() {
    val movie = Movie("Home Alone")
    Column(
        modifier = Modifier.width(350.dp)
    ) {
        MovieListItem(movie)
    }
}