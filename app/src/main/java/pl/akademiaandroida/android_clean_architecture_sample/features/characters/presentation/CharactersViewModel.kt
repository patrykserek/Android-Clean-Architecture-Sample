package pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseViewModel
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapper
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.Character
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.GetCharactersUseCase

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    private fun getCharacters(liveData: MutableLiveData<List<Character>>) {
        setPendingState()

        getCharactersUseCase(Unit, viewModelScope) { result ->
            setIdleState()

            result.onSuccess { characters ->
                liveData.value = characters
            }

            result.onFailure { error ->
                error.message?.let { showMessage(it) }
            }
        }
    }

    val characters: LiveData<List<Character>> = _characters
}