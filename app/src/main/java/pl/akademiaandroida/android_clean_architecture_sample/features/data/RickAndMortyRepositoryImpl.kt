package pl.akademiaandroida.android_clean_architecture_sample.features.data

import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.RickAndMortyDao
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.model.EpisodeCached
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class RickAndMortyRepositoryImpl(
    private val api: RickAndMortyAPI,
    private val dao: RickAndMortyDao,
    private val networkStateProvider: NetworkStateProvider
) : RickAndMortyRepository {

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
        val episodes = api.getEpisodes()
            .results
            .map { it.toEpisode() }

        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { dao.saveAllEpisodes(*it) }

        return episodes
    }

}