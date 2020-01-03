package com.nstudiosappdev.games.dashboard.domain

import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.Single

interface GameRepository {

    fun fetchGames(request: GamesRequest): Single<DataHolder<GamesResponse>>

    fun getGameDetail(id: Int): Single<DataHolder<GameDetail>>
}