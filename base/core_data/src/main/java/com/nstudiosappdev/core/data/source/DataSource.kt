package com.nstudiosappdev.core.data.source

import com.nstudiosappdev.core.model.DataHolder
import io.reactivex.Single

interface DataSource {

    interface RetrieveRemoteDataSource<Req, Res : Any> : DataSource {
        fun getResult(request: Req): Single<DataHolder<Res>>
    }
}
