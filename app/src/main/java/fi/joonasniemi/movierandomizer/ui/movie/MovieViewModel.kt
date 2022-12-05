package fi.joonasniemi.movierandomizer.ui.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.movierandomizer.data.Movie
import fi.joonasniemi.movierandomizer.data.OnlineMovieRepository
import fi.joonasniemi.movierandomizer.data.ResponseTitleSuccess
import io.ktor.client.call.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val movieTitle: String) : ViewModel() {
    companion object {
        private const val TAG = "MovieViewModel"
    }

    private val _movie = MutableStateFlow<ResponseTitleSuccess?>(null)
    val movie: StateFlow<ResponseTitleSuccess?> = _movie.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = OnlineMovieRepository.getMovieByTitle(movieTitle)
                val responseMovie = response.body<ResponseTitleSuccess>()
                _movie.value = responseMovie
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            } finally {
                _loading.value = false
            }
        }
    }
}

class MovieViewModelFactory(private val movieTitle: String): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(movieTitle) as T
    }
}