package pl.akademiaandroida.android_clean_architecture_sample.mocks

import org.jetbrains.annotations.TestOnly
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.EpisodeRemote
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.EpisodesResponse
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.ResponseInfo
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.local.model.EpisodeCached

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "some url",
    prev = "some url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "some date"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
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