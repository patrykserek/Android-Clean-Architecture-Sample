package pl.akademiaandroida.android_clean_architecture_sample.features.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.akademiaandroida.android_clean_architecture_sample.features.data.local.model.EpisodeCached

@Dao
interface RickAndMortyDao {

    @Query("SELECT * FROM EpisodeCached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)
}