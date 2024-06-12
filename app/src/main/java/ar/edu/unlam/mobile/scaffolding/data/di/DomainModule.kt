package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.domain.services.GetOptionsService
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
    fun provideGetOptionsUseCase(pokemonRepository: PokemonRepository): GetOptionsUseCase {
        return GetOptionsService(pokemonRepository)
    }
}