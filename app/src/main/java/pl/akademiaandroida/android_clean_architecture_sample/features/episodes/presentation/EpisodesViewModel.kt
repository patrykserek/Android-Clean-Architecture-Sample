package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase

class EpisodesViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : BaseViewModel() {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .apply { getEpisodes() }
    }

    private fun MutableLiveData<List<Episode>>.getEpisodes() {
        setPendingState()

        getEpisodesUseCase(Unit, viewModelScope) { result ->
            setIdleState()

            result.onSuccess { episodes ->
                value = episodes
            }

            result.onFailure { error ->
                error.message?.let { showMessage(it) }
            }
        }
    }

    val episodes: LiveData<List<Episode>> = _episodes

}