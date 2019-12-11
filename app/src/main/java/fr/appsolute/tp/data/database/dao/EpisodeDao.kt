package fr.appsolute.tp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.appsolute.tp.data.model.Episode

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM episode")
    fun selectAll(): List<Episode>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Episode>)

    @Query("SELECT COUNT(*) FROM episode")
    fun getCount(): Int
}