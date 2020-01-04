package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.core.error.DefaultErrorFactory
import com.nstudiosappdev.core.error.ErrorConstants.Companion.API_ERROR_CODE
import com.nstudiosappdev.core.error.ErrorConstants.Companion.API_ERROR_MESSAGE
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.GameRepository
import com.nstudiosappdev.games.dashboard.domain.GamesRequest
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gamesRemoteDataSource: DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse>,
    private val gameDetailRemoteDataSource: DataSource.RetrieveRemoteDataSource<Int, GameDetail>
) : GameRepository {
    override fun fetchGames(request: GamesRequest): Single<DataHolder<GamesResponse>> =
        gamesRemoteDataSource
            .getResult(request)
            .map { it }
            .onErrorReturn { DataHolder.Fail(DefaultErrorFactory().createApiError(API_ERROR_CODE, API_ERROR_MESSAGE)) }
            .subscribeOn(Schedulers.io())

    override fun getGameDetail(id: Int): Single<DataHolder<GameDetail>> =
        gameDetailRemoteDataSource
            .getResult(id)
            .map { it }
            .onErrorReturn { DataHolder.Fail(DefaultErrorFactory().createApiError(API_ERROR_CODE, API_ERROR_MESSAGE)) }
            .subscribeOn(Schedulers.io())

}