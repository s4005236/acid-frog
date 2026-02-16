package ajahn.dhsn.acid_frog.di

import ajahn.dhsn.acid_frog.common.Constants
import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
import ajahn.dhsn.acid_frog.data.repository.ProductRepositoryImpl
import ajahn.dhsn.acid_frog.domain.repository.ProductRepository
import androidx.compose.ui.unit.Constraints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AcidFrogModule {

    @Provides
    @Singleton
    fun provideOpenFoodFactsApi(): OpenFoodFactsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenFoodFactsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: OpenFoodFactsApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }
}