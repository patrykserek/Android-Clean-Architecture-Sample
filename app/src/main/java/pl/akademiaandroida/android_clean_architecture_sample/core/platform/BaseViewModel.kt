package pl.akademiaandroida.android_clean_architecture_sample.core.platform

import androidx.lifecycle.*
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel(), LifecycleObserver {

    protected val _uiState by lazy { LiveEvent<UiState>() }
    val uiState: LiveData<UiState> = _uiState

    protected val _message by lazy { LiveEvent<String>() }
    val message = _message

    protected fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    protected fun showMessage(message: String) {
        _message.value = message
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected open fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected open fun onDestroy() {
    }
}