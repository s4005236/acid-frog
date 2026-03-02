package ajahn.dhsn.acid_frog.data.database

import ajahn.dhsn.acid_frog.data.database.dao.ProfileDao
import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Abstract class representing the Room database for the application.
 *
 * This database includes a single table for [ProfileEntity] and uses [TypeConversion] for handling
 * custom data types. The database version is set to 1, and schema export is enabled for debugging
 * and version control purposes.
 *
 * @property profileDao The Data Access Object (DAO) for [ProfileEntity] operations.
 */
@Database(entities = [
    ProfileEntity::class],
    version = 1, exportSchema = true)
@TypeConverters(TypeConversion::class)
abstract class AppDatabase : RoomDatabase(){
    /**
     * Provides access to the [ProfileDao] for profile-related database operations.
     */
    abstract val profileDao : ProfileDao

    /**
     * Companion object for [AppDatabase] providing constants and utility methods.
     */
    companion object {
        const val DATABASE_NAME = "app_database"
    }
}