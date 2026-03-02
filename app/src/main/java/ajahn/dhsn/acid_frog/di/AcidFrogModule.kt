package ajahn.dhsn.acid_frog.di

import ajahn.dhsn.acid_frog.common.Constants
import ajahn.dhsn.acid_frog.data.database.AppDatabase
import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
import ajahn.dhsn.acid_frog.data.repository.api.ProductRepositoryImpl
import ajahn.dhsn.acid_frog.data.repository.room.ProfileRepositoryImpl
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing application-wide dependencies.
 *
 * This module is installed in the [SingletonComponent] and provides singleton instances
 * of API clients, repositories, and database components.
 */
@Module
@InstallIn(SingletonComponent::class)
object AcidFrogModule {

    /**
     * Provides a singleton instance of the [OpenFoodFactsApi].
     *
     * @return A configured [OpenFoodFactsApi] instance using Retrofit.
     */
    @Provides
    @Singleton
    fun provideOpenFoodFactsApi(): OpenFoodFactsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenFoodFactsApi::class.java)
    }

    /**
     * Provides a singleton instance of the [ProductRepository].
     *
     * @param api The [OpenFoodFactsApi] instance to use for repository operations.
     * @return A [ProductRepository] implementation backed by the provided API.
     */
    @Provides
    @Singleton
    fun provideProductRepository(api: OpenFoodFactsApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    /**
     * Provides a singleton instance of the [AppDatabase].
     *
     * @param app The [Application] context used to build the database.
     * @return A configured [AppDatabase] instance using Room.
     */
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    /**
     * Provides a singleton instance of the [ProfileRepository].
     *
     * @param db The [AppDatabase] instance to use for repository operations.
     * @return A [ProfileRepository] implementation backed by the provided database.
     */
    @Provides
    @Singleton
    fun provideProfileRepository(db: AppDatabase): ProfileRepository {
        return ProfileRepositoryImpl(db.profileDao)
    }
}
