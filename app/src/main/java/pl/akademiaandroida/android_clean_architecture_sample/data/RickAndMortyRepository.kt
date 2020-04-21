package pl.akademiaandroida.android_clean_architecture_sample.data

import pl.akademiaandroida.android_clean_architecture_sample.data.remote.API
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class RickAndMortyRepository(
    private val api: API
) {

    suspend fun getCharacters(): List<Character> {
        return api.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    suspend fun getLocations(): List<Location> {
        return api.getLocations()
            .results
            .map { it.toLocation() }
    }

    suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

}