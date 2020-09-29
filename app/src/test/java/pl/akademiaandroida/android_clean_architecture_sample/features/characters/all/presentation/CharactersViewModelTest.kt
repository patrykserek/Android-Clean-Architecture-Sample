package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.UiState
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapper
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.GetCharactersUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator.CharacterNavigator
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock
import pl.akademiaandroida.android_clean_architecture_sample.utils.ViewModelTest
import pl.akademiaandroida.android_clean_architecture_sample.utils.getOrAwaitValue
import pl.akademiaandroida.android_clean_architecture_sample.utils.observeForTesting

internal class CharactersViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN characters live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val navigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, navigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `WHEN characters live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val navigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, navigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `GIVEN use case result is success WHEN characters live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val navigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, navigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.status shouldBe character.status
            characterDisplayable.species shouldBe character.species
            characterDisplayable.type shouldBe character.type
            characterDisplayable.gender shouldBe character.gender
            characterDisplayable.originName shouldBe character.origin.name
            characterDisplayable.locationName shouldBe character.location.name
            characterDisplayable.image shouldBe character.image
            characterDisplayable.episodes shouldBe character.episodes
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN characters live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val navigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = CharactersViewModel(useCase, navigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}