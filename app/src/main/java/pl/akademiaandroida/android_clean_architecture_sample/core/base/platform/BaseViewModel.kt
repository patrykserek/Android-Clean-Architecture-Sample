package pl.akademiaandroida.android_clean_architecture_sample.core.base.platform

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    protected val _uiState by lazy {
        MutableLiveData<UiState>(
            UiState.Idle
        )
    }
    val uiState: LiveData<UiState> by lazy { _uiState }

    protected val _message by lazy { LiveEvent<String>() }
    val message: LiveData<String> by lazy { _message }

    protected fun setIdleState() {
        _uiState.value =
            UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value =
            UiState.Pending
    }

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun handleFailure(throwable: Throwable) {
        throwable.message
            ?.let { showMessage(it) }
    }
}