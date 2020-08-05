package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

class Location(
    val id: Int? = null,
    val name: String,
    val type: String? = null,
    val dimension: String? = null,
    val residents: List<String> = emptyList(),
    val url: String
)
