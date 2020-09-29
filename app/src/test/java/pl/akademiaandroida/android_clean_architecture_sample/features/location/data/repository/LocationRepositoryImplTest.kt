package pl.akademiaandroida.android_clean_architecture_sample.features.location.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.core.api.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.LocationsResponse
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapper
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.LocationDao
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.LocationRepository
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        //given
        val api = mockk<RickAndMortyAPI> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        //given
        val api = mockk<RickAndMortyAPI> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        //given
        val api = mockk<RickAndMortyAPI>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.getLocations() }
    }
}