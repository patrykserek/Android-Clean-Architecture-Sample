package pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.core.api.RickAndMortyAPI
import pl.akademiaandroida.android_clean_architecture_sample.core.api.model.CharactersResponse
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapper
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.CharacterDao
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model.CharacterCached
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterRepository
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        //given
        val api = mockk<RickAndMortyAPI> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        //given
        val api = mockk<RickAndMortyAPI> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        //given
        val api = mockk<RickAndMortyAPI>(relaxed = true)
        val characterDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.getCharacters() }
    }
}