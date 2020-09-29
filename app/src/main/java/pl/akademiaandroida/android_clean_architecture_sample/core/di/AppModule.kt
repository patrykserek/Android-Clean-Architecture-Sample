package pl.akademiaandroida.android_clean_architecture_sample.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapper
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapperImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapper
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapperImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.navigation.FragmentNavigator
import pl.akademiaandroida.android_clean_architecture_sample.core.navigation.FragmentNavigatorImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProviderImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.provider.ActivityProvider

val appModule = module {
    factory { DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.screen_episodes,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_open_enter }
            anim { popExit = R.anim.fragment_open_exit }
        }
    }
}