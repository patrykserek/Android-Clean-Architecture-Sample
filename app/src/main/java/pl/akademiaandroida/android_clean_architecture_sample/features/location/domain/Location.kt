package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    companion object
}
