package pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterLocation
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterOrigin

@Entity
class CharacterCached(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "CharacterOriginCached") val origin: CharacterOriginCached,
    @Embedded(prefix = "CharacterLocationCached") val location: CharacterLocationCached,
    val image: String,
    val episodes: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        CharacterOriginCached(character.origin),
        CharacterLocationCached(character.location),
        character.image,
        character.episodes,
        character.url
    )

    fun toCharacter() = Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.toCharacterOrigin(),
        location.toCharacterLocation(),
        image,
        episodes,
        url
    )
}

class CharacterOriginCached(
    val name: String,
    val url: String
) {

    constructor(origin: CharacterOrigin) : this(origin.name, origin.url)

    fun toCharacterOrigin() = CharacterOrigin(name, url)

}

class CharacterLocationCached(
    val name: String,
    val url: String
) {

    constructor(location: CharacterLocation) : this(location.name, location.url)

    fun toCharacterLocation() = CharacterLocation(name, url)

}
