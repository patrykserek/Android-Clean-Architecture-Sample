package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.base.domain.UseCase

class GetEpisodesUseCase(private val repository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = repository.getEpisodes()

}