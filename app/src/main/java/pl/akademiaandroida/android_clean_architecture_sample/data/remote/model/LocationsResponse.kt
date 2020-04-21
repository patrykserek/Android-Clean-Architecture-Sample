package pl.akademiaandroida.android_clean_architecture_sample.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.empty
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location


class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
)

class LocationRemote(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String = String.empty(),
    @SerializedName("dimension") val dimension: String = String.empty(),
    @SerializedName("residents") val residents: List<String> = emptyList(),
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String = String.empty()
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