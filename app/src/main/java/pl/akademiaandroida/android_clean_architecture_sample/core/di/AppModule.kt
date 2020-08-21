package pl.akademiaandroida.android_clean_architecture_sample.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapper
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorMapperImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapper
import pl.akademiaandroida.android_clean_architecture_sample.core.exception.ErrorWrapperImpl
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProviderImpl

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), 2) }
    factory { DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
}