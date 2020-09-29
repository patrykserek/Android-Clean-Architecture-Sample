package pl.akademiaandroida.android_clean_architecture_sample.core.api.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterLocation
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterOrigin

class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
)

class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: CharacterOriginRemote,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episodes: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
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


class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {

    fun toCharacterOrigin() = CharacterOrigin(name, url)
}

class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {

    fun toCharacterLocation() = CharacterLocation(name, url)
}