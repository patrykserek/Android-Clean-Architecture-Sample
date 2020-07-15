package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository

class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked then execute getEpisodes method from repository`() {
        //given
        val repository = mockk<RickAndMortyRepository>()
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            viewModelScope = GlobalScope //Should be replaced with TestCoroutineScope when it will be in a stable channel
        )

        //than
        coVerify { repository.getEpisodes() }
    }
}