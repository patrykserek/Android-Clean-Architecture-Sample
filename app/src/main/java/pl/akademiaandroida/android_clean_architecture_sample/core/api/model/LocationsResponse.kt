package pl.akademiaandroida.android_clean_architecture_sample.core.api.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location


class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
)

class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
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