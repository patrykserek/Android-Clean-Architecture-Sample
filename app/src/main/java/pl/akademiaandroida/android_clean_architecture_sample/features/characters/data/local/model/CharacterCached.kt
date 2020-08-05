package pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached

@Entity
class CharacterCached(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "CharacterOriginCached") val origin: LocationCached,
    @Embedded(prefix = "CharacterLocationCached") val location: LocationCached,
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
        LocationCached(
            name = character.origin.name,
            url = character.origin.url
        ),
        LocationCached(
            name = character.location.name,
            url = character.location.url
        ),
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
        origin.toLocation(),
        location.toLocation(),
        image,
        episodes,
        url
    )
}
