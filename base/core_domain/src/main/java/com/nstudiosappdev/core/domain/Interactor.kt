package com.nstudiosappdev.core.domain

import com.nstudiosappdev.core.model.DataHolder
import io.reactivex.Observable

interface Interactor {

    interface ReactiveRetrieveInteractor<P : Params, R : Any> : Interactor {
        fun execute(params: P): Observable<DataHolder<R>>
    }

    // marker class
    abstract class Params
}
