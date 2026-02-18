package ajahn.dhsn.acid_frog.data.database

import ajahn.dhsn.acid_frog.data.database.dao.ProfileDao
import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [
    ProfileEntity::class],
    version = 1, exportSchema = true)
@TypeConverters(TypeConversion::class)
abstract class AppDatabase : RoomDatabase(){
    abstract val profileDao : ProfileDao
    companion object {
        const val DATABASE_NAME = "app_database"
    }
}