package pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location


class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
)

class LocationRemote(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String? = null,
    @SerializedName("dimension") val dimension: String? = null,
    @SerializedName("residents") val residents: List<String> = emptyList(),
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String? = null
) {
    fun toLocation() = Location(
        id,
        name,
        type,
        dimension,
        residents,
        url
    )
}