package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.GamesRequest
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import io.reactivex.Single
import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse> {

    override fun getResult(request: GamesRequest): Single<DataHolder<GamesResponse>> =
        gameServices.fetchGames(
            pageSize = request.pageSize,
            page = request.page
        )

            .map {
                return@map DataHolder.Success(
                    GamesResponse(
                        count = it.count,
                        next = it.next,
                        previous = it.previous,
                        results = it.results
                    )
                )
            }

}