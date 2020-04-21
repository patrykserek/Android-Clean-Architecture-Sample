package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.empty

class Location(
    val id: Int = 0,
    val name: String,
    val type: String = String.empty(),
    val dimension: String = String.empty(),
    val residents: List<String> = emptyList(),
    val url: String
)
