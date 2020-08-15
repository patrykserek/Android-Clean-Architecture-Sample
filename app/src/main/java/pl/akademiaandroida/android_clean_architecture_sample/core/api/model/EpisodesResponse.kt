package pl.akademiaandroida.android_clean_architecture_sample.core.api.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode


class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}

class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode") val code: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    companion object

    fun toEpisode() = Episode(
        id,
        name,
        airDate,
        code,
        characters,
        url
    )

}