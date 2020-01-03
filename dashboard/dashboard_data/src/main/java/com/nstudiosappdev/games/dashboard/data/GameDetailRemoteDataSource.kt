package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.source.DataSource
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.Single
import javax.inject.Inject

class GameDetailRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<Int, GameDetail> {

    override fun getResult(request: Int): Single<DataHolder<GameDetail>> =
        gameServices.getGameDetail(request)

            .map { return@map DataHolder.Success(it) }
}