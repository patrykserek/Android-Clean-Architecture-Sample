package pl.akademiaandroida.android_clean_architecture_sample.features.location.data.repository

import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.LocationDao
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.LocationRepository

class LocationRepositoryImpl(
    private val api: RickAndMortyAPI,
    private val dao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote()
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return api.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return dao.getLocations()
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(episodes: List<Location>) {
        episodes.map { LocationCached(it) }
            .toTypedArray()
            .let { dao.saveLocations(*it) }
    }
}