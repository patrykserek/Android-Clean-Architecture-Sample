package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episodes: List<String>,
    val url: String
)