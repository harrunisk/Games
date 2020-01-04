package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.core.error.ErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.GameDetailInteractor
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameDetailViewModel @Inject constructor(
    private val gameDetailInteractor: Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.GameInteractorParams, GameDetail>,
    private val gameDetailViewEntityMapper: Function<GameDetail, DisplayItem>,
    private val errorFactory: ErrorFactory
) : ViewModel() {

    private val _gameDetailLiveData = MediatorLiveData<DataHolder<DisplayItem>>()

    val gameDetailLiveData: LiveData<DataHolder<DisplayItem>>
        get() = _gameDetailLiveData

    private val compositeDisposable = CompositeDisposable()

    fun getGameDetail(id: Int) {
        _gameDetailLiveData.value = DataHolder.Loading()
        val params = GameDetailInteractor.GameInteractorParams(
            id = id
        )
        val gameDetailDisposable = gameDetailInteractor.execute(params)
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it) {
                    is DataHolder.Success -> {

                        _gameDetailLiveData.postValue(
                            DataHolder.Success(
                                gameDetailViewEntityMapper.apply(
                                    it.data
                                )
                            )
                        )
                    }
                }
            }, {
                _gameDetailLiveData.postValue(
                    DataHolder.Fail(
                        errorFactory.createErrorFromThrowable(
                            it
                        )
                    )
                )
            })
        compositeDisposable.add(gameDetailDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}