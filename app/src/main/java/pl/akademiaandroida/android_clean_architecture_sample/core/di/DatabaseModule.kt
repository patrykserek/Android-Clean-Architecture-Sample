package pl.akademiaandroida.android_clean_architecture_sample.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.core.database.AppDatabase

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "rickAndMortyDb"
        ).build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().characterDao() }
    single { get<AppDatabase>().locationDao() }

}