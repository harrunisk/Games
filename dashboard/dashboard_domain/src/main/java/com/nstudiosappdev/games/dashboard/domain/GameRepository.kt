package com.nstudiosappdev.games.dashboard.domain

import com.nstudiosappdev.core.model.DataHolder
import io.reactivex.Single

interface GameRepository {

    fun fetchGames(request: GamesRequest): Single<DataHolder<GamesResponse>>
}