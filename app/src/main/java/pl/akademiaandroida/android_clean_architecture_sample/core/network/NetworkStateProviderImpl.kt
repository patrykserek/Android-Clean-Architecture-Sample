package pl.akademiaandroida.android_clean_architecture_sample.core.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkStateProviderImpl(private val connectivityManager: ConnectivityManager) :
    NetworkStateProvider {

    override fun isNetworkAvailable(): Boolean {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?: return false

        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    or capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    or capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}