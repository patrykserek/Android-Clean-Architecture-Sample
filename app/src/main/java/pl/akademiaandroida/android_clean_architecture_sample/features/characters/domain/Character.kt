package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String,
    val episodes: List<String>,
    val url: String
) {
    companion object
}

class CharacterOrigin(
    val name: String,
    val url: String
)

class CharacterLocation(
    val name: String,
    val url: String
)