package pl.akademiaandroida.android_clean_architecture_sample.features.domain

import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character

interface RickAndMortyRepository {
    suspend fun getCharacters(): List<Character>
}