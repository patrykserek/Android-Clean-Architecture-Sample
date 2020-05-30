package pl.akademiaandroida.android_clean_architecture_sample.features.data.remote

import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.CharactersResponse
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.EpisodesResponse
import pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

}