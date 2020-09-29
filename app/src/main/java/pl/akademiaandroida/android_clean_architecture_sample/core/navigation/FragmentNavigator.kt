package pl.akademiaandroida.android_clean_architecture_sample.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {

    fun navigateTo(
        @IdRes destinationId: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun <T> navigateTo(
        @IdRes destinationId: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(
        @IdRes destinationId: Int? = null,
        inclusive: Boolean = false
    )

    fun clearHistory()
}