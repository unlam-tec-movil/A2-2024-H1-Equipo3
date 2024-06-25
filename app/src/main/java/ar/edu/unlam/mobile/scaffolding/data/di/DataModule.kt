package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.GameHistoryRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalDataSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db.GameDao
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.PokemonRepositoryImpl
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.PokemonRemoteDataSource
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.PokemonRemoteSource
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun providePokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository

    @Binds
    @Singleton
    abstract fun providePokemonRemoteSource(pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonRemoteSource

    @Binds
    @Singleton
    abstract fun bindGameRepository(
        gameHistoryRepository: GameHistoryRepository
    ): GameRepository

    @Binds
    @Singleton
    abstract fun provideGameLocalSource(
        gameLocalDataSource: GameLocalDataSource
    ): GameLocalSource


}
