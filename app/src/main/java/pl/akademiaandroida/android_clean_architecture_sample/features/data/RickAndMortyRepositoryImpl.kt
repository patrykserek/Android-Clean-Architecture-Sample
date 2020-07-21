package pl.akademiaandroida.android_clean_architecture_sample.features.data

import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.local.EpisodeDao

class RickAndMortyRepositoryImpl(
    private val api: RickAndMortyAPI,
    private val dao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : RickAndMortyRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters()
            .results
            .map { it.toCharacter() }
    }

}