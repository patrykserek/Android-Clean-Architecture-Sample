package pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.local.model.LocationCached

@Dao
interface LocationDao {

    @Query("SELECT * FROM LocationCached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg episode: LocationCached)

}