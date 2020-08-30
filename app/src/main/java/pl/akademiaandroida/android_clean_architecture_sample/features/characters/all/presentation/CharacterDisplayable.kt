package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character

@Parcelize
data class CharacterDisplayable(
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
) : Parcelable {

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

    companion object
}