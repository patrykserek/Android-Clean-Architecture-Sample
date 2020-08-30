package pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.navigation.FragmentNavigator
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable
import pl.akademiaandroida.android_clean_architecture_sample.mocks.mock

internal class CharacterNavigatorImplTest {

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with action to navigate to character details screen AND character model as arguments`() {
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        characterNavigator.openCharacterDetailsScreen(character)

        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_screen_characters_to_screen_character_details,
                capture(slot)
            )
        }

        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        characterNavigator.goBack()

        verify { fragmentNavigator.goBack() }
    }
}