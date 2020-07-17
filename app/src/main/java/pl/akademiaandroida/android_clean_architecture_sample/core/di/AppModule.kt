package pl.akademiaandroida.android_clean_architecture_sample.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProvider
import pl.akademiaandroida.android_clean_architecture_sample.core.network.NetworkStateProviderImpl

val appModule = module {
    factory<RecyclerView.LayoutManager> { LinearLayoutManager(androidContext()) }
    factory { DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }

}