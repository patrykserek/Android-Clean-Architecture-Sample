package pl.akademiaandroida.android_clean_architecture_sample.data.remote

import pl.akademiaandroida.android_clean_architecture_sample.data.remote.model.CharactersResponse
import pl.akademiaandroida.android_clean_architecture_sample.data.remote.model.EpisodesResponse
import pl.akademiaandroida.android_clean_architecture_sample.data.remote.model.LocationsResponse
import retrofit2.http.GET

interface API {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

}