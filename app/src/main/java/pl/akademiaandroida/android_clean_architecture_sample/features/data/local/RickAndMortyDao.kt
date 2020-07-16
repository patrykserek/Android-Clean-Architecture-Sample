package pl.akademiaandroida.android_clean_architecture_sample.features.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.model.EpisodeCached

@Dao
interface RickAndMortyDao {

    @Query("SELECT * FROM EpisodeCached")
    fun getAllEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllEpisodes(vararg episode: EpisodeCached)
}