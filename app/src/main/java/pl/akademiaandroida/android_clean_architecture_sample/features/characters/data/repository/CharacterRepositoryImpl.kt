package pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.repository

import pl.akademiaandroida.android_clean_architecture_sample.core.api.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.CharacterDao
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model.CharacterCached
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterRepository

class CharacterRepositoryImpl(
    private val api: RickAndMortyAPI,
    private val dao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return api.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return dao.getCharacters()
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { dao.saveCharacters(*it) }
    }
}