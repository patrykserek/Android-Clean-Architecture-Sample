package pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation

import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character

class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originName: String,
    val locationName: String,
    val image: String,
    val episodes: List<String>
) {

    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        character.origin.name,
        character.location.name,
        character.image,
        character.episodes
    )
}