package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}