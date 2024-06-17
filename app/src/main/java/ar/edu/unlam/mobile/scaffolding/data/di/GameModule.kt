package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.GameHistoryRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalDataSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db.GameDao
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class GameModule {

    @Binds
    @Singleton
    abstract fun bindGameRepository(
        gameHistoryRepository: GameHistoryRepository
    ): GameRepository

    @Provides
    @Singleton
    fun provideGameLocalSource(
        gameDao: GameDao
    ): GameLocalSource = GameLocalDataSource(gameDao)


}