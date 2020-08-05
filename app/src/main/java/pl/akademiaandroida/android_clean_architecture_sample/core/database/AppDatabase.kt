package pl.akademiaandroida.android_clean_architecture_sample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.CharacterDao
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model.CharacterCached
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.local.EpisodeDao
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.local.model.EpisodeCached
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.LocationDao
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached

@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
    abstract fun characterDao(): CharacterDao
}