package ar.edu.unlam.mobile.scaffolding.data.di

import android.content.Context
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db.TriviaDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideTriviaDatabase(@ApplicationContext context: Context): TriviaDb {
        return TriviaDb.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideGameDao(triviaDb: TriviaDb) = triviaDb.gameDao()

}