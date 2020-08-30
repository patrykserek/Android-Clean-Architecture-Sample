package pl.akademiaandroida.android_clean_architecture_sample.core.navigation

import androidx.navigation.NavOptions

interface FragmentNavigator {

    fun <T> navigateTo(
        destinationId: Int,
        param: Pair<String, T>? = null,
        navOptions: NavOptions? = null
    )

    fun navigateTo(
        destinationId: Int,
        navOptions: NavOptions? = null
    )

    fun goBack(destinationId: Int? = null, inclusive: Boolean = false)

    fun clearHistory()
}