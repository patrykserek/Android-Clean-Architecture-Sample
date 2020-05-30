package pl.akademiaandroida.android_clean_architecture_sample.features.data

import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class RickAndMortyRepositoryImpl(private val api: RickAndMortyAPI) : RickAndMortyRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    override suspend fun getLocations(): List<Location> {
        return api.getLocations()
            .results
            .map { it.toLocation() }
    }

    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

}