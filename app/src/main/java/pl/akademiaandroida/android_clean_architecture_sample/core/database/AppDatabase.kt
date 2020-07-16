package pl.akademiaandroida.android_clean_architecture_sample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.RickAndMortyDao
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rickAndMortyDao(): RickAndMortyDao
}