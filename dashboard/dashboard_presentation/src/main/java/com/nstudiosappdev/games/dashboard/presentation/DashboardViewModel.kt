package com.nstudiosappdev.games.dashboard.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nstudiosappdev.core.domain.Interactor
import com.nstudiosappdev.core.error.ErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.GamesInteractor
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import com.nstudiosappdev.games.dashboard.domain.objects.Game
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.functions.Function

class DashboardViewModel @Inject constructor(
    private val gamesInteractor: Interactor.ReactiveRetrieveInteractor<GamesInteractor.GamesInteractorParams, GamesResponse>,
    private val gameViewEntityMapper: Function<Game, DisplayItem>,
    private val errorFactory: ErrorFactory
) : ViewModel() {

    private val _gamesLiveData = MediatorLiveData<DataHolder<List<DisplayItem>>>()
    private val _pageLiveData = MutableLiveData<Int>()
    private val compositeDisposable = CompositeDisposable()
    private val games = ArrayList<DisplayItem>()
    private val page = Page()

    val gamesLiveData: LiveData<DataHolder<List<DisplayItem>>>
        get() = _gamesLiveData

    init {
        _gamesLiveData.value = DataHolder.Success(games)
        _gamesLiveData.addSource(_pageLiveData) {
            getGames(it, 10)
        }
    }

    fun getGamesByPagination() {
        _pageLiveData.value?.let {
            val nextPage = page.currentPage + 1
            if (nextPage > page.totalPages) {
                return
            }
            _pageLiveData.value = nextPage
        } ?: run {
            _pageLiveData.value = page.currentPage
        }
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

                when (it) {
                    is DataHolder.Success -> {
                        this.page.currentPage++
                        this.page.totalPages = it.data.count!!

                        Observable.fromIterable(it.data.results)
                            .map { item -> gameViewEntityMapper.apply(item) }
                            .toList()
                            .blockingGet()
                            .run {
                                _gamesLiveData.postValue(DataHolder.Success(this))
                                games.addAll(this)
                            }
                    }
                }
            }, {
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

    data class Page(
        var currentPage: Int = 1,
        var totalPages: Int = 1
    )
}