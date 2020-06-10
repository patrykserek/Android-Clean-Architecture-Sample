package pl.akademiaandroida.android_clean_architecture_sample.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<RecyclerView.LayoutManager> { LinearLayoutManager(androidContext()) }
    factory { DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL) }

}