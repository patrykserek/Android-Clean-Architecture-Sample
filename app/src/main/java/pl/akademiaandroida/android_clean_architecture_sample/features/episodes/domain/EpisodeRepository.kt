package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}