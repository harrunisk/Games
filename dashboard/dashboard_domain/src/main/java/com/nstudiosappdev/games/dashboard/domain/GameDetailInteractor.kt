package com.nstudiosappdev.games.dashboard.domain

import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.Observable
import java.lang.IllegalArgumentException
import javax.inject.Inject

class GameDetailInteractor @Inject constructor(
    private val gameRepository: GameRepository
) : Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.GameInteractorParams, GameDetail> {

    override fun execute(params: GameInteractorParams): Observable<DataHolder<GameDetail>> {
        when {
            params.id.toString().isEmpty() -> throw IllegalArgumentException("Invalid id")
            else -> return gameRepository.getGameDetail(
                params.id
            ).toObservable()
        }
    }


    class GameInteractorParams(
        val id: Int
    ) : Interactor.Params()
}