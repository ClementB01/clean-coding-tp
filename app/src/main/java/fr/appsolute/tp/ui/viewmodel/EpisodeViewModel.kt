package fr.appsolute.tp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.appsolute.tp.data.model.Episode
import fr.appsolute.tp.data.repository.EpisodeRepository
import kotlinx.coroutines.launch

typealias OnGetResult<T> = (List<Episode>?) -> Unit
class EpisodeViewModel(
    private val repository: EpisodeRepository
): ViewModel() {

    fun listEpisode(onGetResult: OnGetResult<Episode?>){
        viewModelScope.launch {
            repository.getAllEpisode()?.run(onGetResult)
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return EpisodeViewModel(EpisodeRepository.instance()) as T
        }
    }
}