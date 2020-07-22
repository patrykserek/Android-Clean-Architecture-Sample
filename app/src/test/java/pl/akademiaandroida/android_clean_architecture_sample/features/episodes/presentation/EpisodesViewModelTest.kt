package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.viewModelScope
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.UiState
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase
import pl.akademiaandroida.android_clean_architecture_sample.getOrAwaitValue
import pl.akademiaandroida.android_clean_architecture_sample.withInstantExecution

internal class EpisodesViewModelTest {

    @Test
    fun `WHEN episode live data is created THEN invoke use case to get episodes`() {
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        withInstantExecution {
            val viewModel = EpisodesViewModel(useCase)

            //Imo this should initialized _episode live data and invoke getEpisode method.
            //It works when setPendingState method in EpisodeViewModel is commented.
            viewModel.episodes.value

            //For now i just want to check if use case is executed in any way.
            verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
        }
    }

    @Test
    fun `WHEN episode live data is created THEN set pending state`() {
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)

        withInstantExecution {
            val viewModel = EpisodesViewModel(useCase)

            viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
        }
    }
}