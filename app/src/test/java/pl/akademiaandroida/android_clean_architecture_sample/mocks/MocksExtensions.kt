package pl.akademiaandroida.android_clean_architecture_sample.mocks

import org.jetbrains.annotations.TestOnly
import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.*
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.local.model.EpisodeCached
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

@TestOnly
fun ResponseInfo.Companion.mock() =
    ResponseInfo(
        count = 10,
        pages = 3,
        next = "some url",
        prev = "some url"
    )

@TestOnly
fun EpisodeRemote.Companion.mock() =
    EpisodeRemote(
        id = 1,
        name = "episode name",
        airDate = "episode air date",
        code = "episode code",
        characters = emptyList(),
        url = "episode url",
        created = "some date"
    )

@TestOnly
fun EpisodesResponse.Companion.mock() =
    EpisodesResponse(
        info = ResponseInfo.mock(),
        results = listOf(
            EpisodeRemote.mock(),
            EpisodeRemote.mock(),
            EpisodeRemote.mock()
        )
    )

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)


fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    id = 1,
    name = "Rick",
    status = "",
    species = "",
    type = "human",
    gender = "male",
    originName = "Earth",
    locationName = "Earth",
    image = "example image url",
    episodes = emptyList()
)


fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "Earth",
    type = "Planet",
    dimension = "unknown",
    residents = emptyList(),
    url = "example url",
    created = "example date"
)

fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "Earth",
    type = "Planet",
    dimension = "unknown",
    residents = emptyList(),
    url = "example url"
)

fun Location.Companion.mock() = Location(
    id = 1,
    name = "Earth",
    type = "Planet",
    dimension = "unknown",
    residents = emptyList(),
    url = "example url"
)