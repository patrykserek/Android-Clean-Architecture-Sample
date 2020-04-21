package pl.akademiaandroida.android_clean_architecture_sample.data

import pl.akademiaandroida.android_clean_architecture_sample.data.remote.API
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode

class RickAndMortyRepository(
    private val api: API
) {

    suspend fun getCharacters() = api.getCharacters()

    suspend fun getLocations() = api.getLocations()

    suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

}