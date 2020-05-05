package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.GetLocationsUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.Location

class LocationViewModel(private val getLocationsUseCase: GetLocationsUseCase) : BaseViewModel() {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .apply { getLocations() }
    }

    private fun MutableLiveData<List<Location>>.getLocations() {
        setPendingState()

        getLocationsUseCase(Unit, viewModelScope) { result ->
            setIdleState()

            result.onSuccess { locations ->
                value = locations
            }

            result.onFailure { error ->
                error.message?.let { showMessage(it) }
            }
        }
    }

    val locations: LiveData<List<Location>> = _locations
}