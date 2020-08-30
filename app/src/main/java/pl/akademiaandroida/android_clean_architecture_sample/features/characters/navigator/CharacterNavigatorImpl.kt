package pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator

import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.navigation.FragmentNavigator
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_screen_characters_to_screen_character_details,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}