package pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation

import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock
import pl.akademiaandroida.android_clean_architecture_sample.utils.ViewModelTest
import pl.akademiaandroida.android_clean_architecture_sample.utils.getOrAwaitValue

internal class CharacterDetailsViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character is passed from previous screen THAN show it`() {
        //given
        val viewModel = CharacterDetailsViewModel()
        val character = CharacterDisplayable.mock()

        //when
        viewModel.onCharacterPassed(character)

        //than
        viewModel.character.getOrAwaitValue() shouldBe character
    }

}