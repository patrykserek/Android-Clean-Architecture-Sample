package pl.akademiaandroida.android_clean_architecture_sample.features.domain

import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

interface RickAndMortyRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getLocations(): List<Location>
    suspend fun getEpisodes(): List<Episode>
}