package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.UiState
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.Episode
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock
import pl.akademiaandroida.android_clean_architecture_sample.utils.ViewModelTest
import pl.akademiaandroida.android_clean_architecture_sample.utils.getOrAwaitValue
import pl.akademiaandroida.android_clean_architecture_sample.utils.observeForTesting

internal class EpisodesViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `GIVEN use case result is success WHEN episode live data is observed THEN set idle state AND set result in live data`() {
        //given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val viewModel = EpisodesViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}