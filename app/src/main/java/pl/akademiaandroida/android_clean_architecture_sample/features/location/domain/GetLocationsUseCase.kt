package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.domain.UseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository

class GetLocationsUseCase(private val repository: RickAndMortyRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = repository.getLocations()
}