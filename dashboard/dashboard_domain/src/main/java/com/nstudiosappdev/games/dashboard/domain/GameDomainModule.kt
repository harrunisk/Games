package com.nstudiosappdev.games.dashboard.domain

import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import dagger.Module
import dagger.Provides

@Module
class GameDomainModule {

    @Provides
    fun provideGamesInteractor(gameRepository: GameRepository):
            Interactor.ReactiveRetrieveInteractor<GamesInteractor.GamesInteractorParams, GamesResponse> =
      GamesInteractor(gameRepository)

    @Provides
    fun provideGameInteractor(gameRepository: GameRepository):
            Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.GameInteractorParams, GameDetail> =
        GameDetailInteractor(gameRepository)
}