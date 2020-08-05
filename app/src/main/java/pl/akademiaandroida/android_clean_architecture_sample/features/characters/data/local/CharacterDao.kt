package pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.local.model.CharacterCached

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterCached")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)
}