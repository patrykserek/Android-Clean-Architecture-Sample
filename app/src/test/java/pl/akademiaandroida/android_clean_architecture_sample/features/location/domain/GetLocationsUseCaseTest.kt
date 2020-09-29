package pl.akademiaandroida.android_clean_architecture_sample.features.location.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {

    @Test
    fun `WHEN use case is invoked THAN execute getLocations method from repository`() {
        //given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        //when
        useCase(
            params = Unit,
            viewModelScope = GlobalScope //Should be replaced with TestCoroutineScope when it will be in a stable channel
        )

        //than
        coVerify { repository.getLocations() }
    }
}