package fi.joonasniemi.movierandomizer.components

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MovieItem(title: String) {
    Card {
        Text(title)
    }
}

@Preview
@Composable
fun PreviewMovieItem() {
    MovieItem("Home Alone")
}