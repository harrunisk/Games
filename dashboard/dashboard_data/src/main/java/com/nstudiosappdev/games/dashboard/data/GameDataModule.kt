package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.games.dashboard.domain.GameRepository
import com.nstudiosappdev.games.dashboard.domain.GamesRequest
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GameDataModule {

    @Provides
    @Singleton
    fun provideGameServices(retrofit: Retrofit): GameServices =
        retrofit.create(GameServices::class.java)

    @Provides
    @Singleton
    fun provideGamesRemoteDataSource(gameServices: GameServices): DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse> =
        GamesRemoteDataSource(gameServices)

    @Provides
    @Singleton
    fun provideGameDetailRemoteDataSource(gameServices: GameServices): DataSource.RetrieveRemoteDataSource<Int, GameDetail> =
        GameDetailRemoteDataSource(gameServices)

    @Provides
    @Singleton
    fun provideGameRepository(
        gamesRemoteDataSource: GamesRemoteDataSource,
        gameDetailRemoteDataSource: GameDetailRemoteDataSource
    ): GameRepository = GameRepositoryImpl(
        gamesRemoteDataSource,
        gameDetailRemoteDataSource
    )
}