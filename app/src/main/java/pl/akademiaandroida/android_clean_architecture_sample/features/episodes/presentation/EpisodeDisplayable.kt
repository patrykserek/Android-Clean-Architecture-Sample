package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode

class EpisodeDisplayable(
    val name: String,
    val airDate: String,
    val code: String
) {

    constructor(episode: Episode) : this(
        episode.name,
        episode.airDate,
        episode.code
    )

    val fullName = "$code: $name"
}