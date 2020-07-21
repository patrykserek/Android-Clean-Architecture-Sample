package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}