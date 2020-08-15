package pl.akademiaandroida.android_clean_architecture_sample.core.base.platform

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}