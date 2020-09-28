package pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable

class CharacterDetailsViewModel : BaseViewModel() {

    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun onCharacterPassed(character: CharacterDisplayable) {
        _character.value = character
    }

}