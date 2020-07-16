package pl.akademiaandroida.android_clean_architecture_sample.features.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode

@Entity
class EpisodeCached(
    @PrimaryKey val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {

    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.code,
        episode.characters,
        episode.url
    )

    fun toEpisode() = Episode(
        id,
        name,
        airDate,
        code,
        characters,
        url
    )
}