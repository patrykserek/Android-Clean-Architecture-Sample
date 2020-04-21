package pl.akademiaandroida.android_clean_architecture_sample.core.platform

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}