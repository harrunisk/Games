package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.games.dashboard.domain.GameRepository
import com.nstudiosappdev.games.dashboard.domain.GamesRequest
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GameDataModule {

    @Provides
    @Singleton
    fun provideGameServices(retrofit: Retrofit): GameServices = retrofit.create(GameServices::class.java)

    @Provides
    @Singleton
    fun provideGamesRemoteDataSource(gameServices: GameServices): DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse> =
        GamesRemoteDataSource(gameServices)

    @Provides
    @Singleton
    fun provideGameRepository(gamesRemoteDataSource: GamesRemoteDataSource): GameRepository =
        GameRepositoryImpl(gamesRemoteDataSource)
}