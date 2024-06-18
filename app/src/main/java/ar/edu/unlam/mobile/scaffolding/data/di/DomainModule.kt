package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.domain.services.GetGameHistoryService
import ar.edu.unlam.mobile.scaffolding.domain.services.GetOptionsService
import ar.edu.unlam.mobile.scaffolding.domain.services.SaveGameService
import ar.edu.unlam.mobile.scaffolding.domain.services.SelectOptionService
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetGamesHistoryUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SaveGameUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SelectOptionUseCase
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

    @Singleton
    @Provides
    fun provideGetGameHistoryUseCase(gameRepository: GameRepository): GetGamesHistoryUseCase {
        return GetGameHistoryService(gameRepository)
    }

    @Singleton
    @Provides
    fun provideSaveGameUseCase(gameRepository: GameRepository): SaveGameUseCase {
        return SaveGameService(gameRepository)
    }

    @Singleton
    @Provides
    fun provideSelectOptionUseCase(): SelectOptionUseCase {
        return SelectOptionService()
    }


}