package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.domain.repository.PokemonRepository
import ar.edu.unlam.mobile.scaffolding.domain.services.GetOptionsService
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
     fun provideGetOptionsUseCase(pokemonRepository: PokemonRepository): GetOptionsUseCase{
         return GetOptionsService(pokemonRepository)
     }
}