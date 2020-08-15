package pl.akademiaandroida.android_clean_architecture_sample.core.api

import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.CharactersResponse
import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.EpisodesResponse
import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

}