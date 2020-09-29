package pl.akademiaandroida.android_clean_architecture_sample.core.navigation

import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import pl.akademiaandroida.android_clean_architecture_sample.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int,
    private val defaultNavOptions: NavOptions
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostFragmentRes)
        ?.findNavController()

    override fun navigateTo(destinationId: Int, navOptions: NavOptions?) {
        navigateTo<Unit>(destinationId, null, navOptions)
    }

    override fun <T> navigateTo(
        destinationId: Int,
        param: Pair<String, T>?,
        navOptions: NavOptions?
    ) {
        getNavController()?.navigate(
            destinationId,
            param?.let { bundleOf(it) },
            navOptions ?: defaultNavOptions
        )
    }

    override fun goBack(@IdRes destinationId: Int?, inclusive: Boolean) {
        if (destinationId == null) {
            getNavController()?.popBackStack()
        } else {
            getNavController()?.popBackStack(destinationId, inclusive)
        }
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}