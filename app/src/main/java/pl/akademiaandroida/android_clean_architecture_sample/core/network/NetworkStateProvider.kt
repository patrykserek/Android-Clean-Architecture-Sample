package pl.akademiaandroida.android_clean_architecture_sample.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}