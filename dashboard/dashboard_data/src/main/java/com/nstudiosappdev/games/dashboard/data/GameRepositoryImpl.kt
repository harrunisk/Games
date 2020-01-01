package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.core.error.DefaultErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.GameRepository
import com.nstudiosappdev.games.dashboard.domain.GamesRequest
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gamesRemoteDataSource: DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse>
) : GameRepository {
    override fun fetchGames(request: GamesRequest): Single<DataHolder<GamesResponse>> =
        gamesRemoteDataSource
            .getResult(request)
            .map { it }
            .onErrorReturn { DataHolder.Fail(DefaultErrorFactory().createApiError(1, "123")) }
            .subscribeOn(Schedulers.io())
}