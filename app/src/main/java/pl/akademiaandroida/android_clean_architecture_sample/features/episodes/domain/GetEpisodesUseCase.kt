package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.domain.UseCase
import pl.akademiaandroida.android_clean_architecture_sample.data.RickAndMortyRepository

class GetEpisodesUseCase(private val repository: RickAndMortyRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = repository.getEpisodes()

}