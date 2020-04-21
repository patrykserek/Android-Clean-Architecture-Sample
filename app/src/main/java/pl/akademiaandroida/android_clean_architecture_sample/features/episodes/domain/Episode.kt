package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain

class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
)
