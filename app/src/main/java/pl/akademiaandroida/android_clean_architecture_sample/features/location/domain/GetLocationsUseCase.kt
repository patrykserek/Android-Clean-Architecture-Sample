package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.base.domain.UseCase

class GetLocationsUseCase(private val repository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = repository.getLocations()
}