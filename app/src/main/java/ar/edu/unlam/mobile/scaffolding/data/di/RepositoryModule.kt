package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.data.repository.PokemonTestRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetPokemonRepositoryUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePokemonRepository(): GetPokemonRepositoryUseCase{
        return PokemonTestRepository
    }

}
