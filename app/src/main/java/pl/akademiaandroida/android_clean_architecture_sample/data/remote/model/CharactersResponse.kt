package pl.akademiaandroida.android_clean_architecture_sample.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

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
    @SerializedName("origin") val origin: LocationRemote,
    @SerializedName("location") val location: LocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
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
        Location(
            name = origin.name,
            url = origin.url
        ),
        Location(
            name = location.name,
            url = location.url
        ),
        image,
        episode,
        url
    )
}
