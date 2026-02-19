package ajahn.dhsn.acid_frog.data.database.dao

import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles")
    fun getAll(): List<ProfileEntity>

    @Query("SELECT * FROM profiles WHERE id=:id")
    suspend fun getProfileById(id: Long): ProfileEntity

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertProfile(note: ProfileEntity): Long

    @Upsert
    suspend fun updateProfile(note: ProfileEntity)

    @Delete
    suspend fun deleteProfile(note: ProfileEntity)

    @Query("DELETE FROM profiles")
    suspend fun deleteAll()

}