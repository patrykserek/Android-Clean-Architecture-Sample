package pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator

import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}