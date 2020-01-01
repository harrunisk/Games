package com.nstudiosappdev.games.dashboard.domain

import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.core.model.DataHolder
import io.reactivex.Observable
import java.lang.IllegalArgumentException
import javax.inject.Inject

class GamesInteractor @Inject constructor(
    private val gameRepository: GameRepository
) : Interactor.ReactiveRetrieveInteractor<GamesInteractor.GamesInteractorParams, GamesResponse> {

    override fun execute(params: GamesInteractorParams): Observable<DataHolder<GamesResponse>> {
        when {
            params.page.toString().isEmpty() -> throw IllegalArgumentException("Invalid page")
            params.pageSize.toString().isEmpty() -> throw IllegalArgumentException("Invalid page size")
            else -> return gameRepository.fetchGames(
                GamesRequest(
                    page = params.page,
                    pageSize = params.pageSize
                )
            ).toObservable()
        }
    }

    class GamesInteractorParams(
        val page: Int?,
        val pageSize: Int?
    ) : Interactor.Params()
}