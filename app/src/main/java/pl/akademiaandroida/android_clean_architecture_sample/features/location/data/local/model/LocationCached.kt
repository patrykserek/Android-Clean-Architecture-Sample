package pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

@Entity
class LocationCached(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.name,
        location.type,
        location.dimension,
        location.residents,
        location.url
    )

    companion object

    fun toLocation() = Location(
        id,
        name,
        type,
        dimension,
        residents,
        url
    )
}