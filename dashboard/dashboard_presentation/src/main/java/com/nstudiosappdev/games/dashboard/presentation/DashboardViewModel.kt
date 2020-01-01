package com.nstudiosappdev.games.dashboard.presentation

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.core.error.ErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.GamesInteractor
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val gamesInteractor: Interactor.ReactiveRetrieveInteractor<GamesInteractor.GamesInteractorParams, GamesResponse>,
    private val errorFactory: ErrorFactory
) : ViewModel() {

    private val _gamesLiveData = MediatorLiveData<DataHolder<GamesResponse>>()
    private val compositeDisposable = CompositeDisposable()


    init {
        getGames(1,1)
    }

    fun getGames(page: Int, pageSize: Int) {
        _gamesLiveData.value = DataHolder.Loading()
        val params = GamesInteractor.GamesInteractorParams(
            page = page,
            pageSize = pageSize
        )

        val gamesGetDisposable = gamesInteractor.execute(params)
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _gamesLiveData.postValue(it)
            },{
                _gamesLiveData.postValue(
                    DataHolder.Fail(
                        errorFactory.createErrorFromThrowable(
                            it
                        )
                    )
                )
            })

        compositeDisposable.add(gamesGetDisposable!!)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}