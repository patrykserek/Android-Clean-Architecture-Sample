package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.getOrNullIfUnknown
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class LocationDisplayable(
    val name: String,
    val type: String,
    val dimension: String?
) {

    constructor(location: Location) : this(
        location.name,
        location.type,
        location.dimension.getOrNullIfUnknown()
    )

}