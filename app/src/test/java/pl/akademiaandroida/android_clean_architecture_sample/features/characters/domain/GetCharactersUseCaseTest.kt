package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest {

    @Test
    fun `WHEN use case is invoked THAN execute getCharacters method from repository`() {
        //given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        //when
        useCase(
            params = Unit,
            viewModelScope = GlobalScope //Should be replaced with TestCoroutineScope when it will be in a stable channel
        )

        //than
        coVerify { repository.getCharacters() }
    }
}