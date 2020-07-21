package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase

internal class EpisodesViewModelTest {

    @Test
    fun `WHEN episode live data is created THAN invoke use case to get episodes`() {
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase)

        //Imo this should initialized _episode live data and invoke getEpisode method.
        //It works when setPendingState method in EpisodeViewModel is commented.
        viewModel.episodes.value

        //For now i just want to check if use case is executed in any way.
        verify { useCase(Unit, any(), any(), any()) }
    }
}