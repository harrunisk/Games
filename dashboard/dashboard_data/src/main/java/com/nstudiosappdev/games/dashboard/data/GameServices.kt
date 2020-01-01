package com.nstudiosappdev.games.dashboard.data

import com.nstudiosappdev.core.data.api.ApiConstants
import com.nstudiosappdev.core.data.api.ApiResponse
import com.nstudiosappdev.games.dashboard.domain.objects.Game
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GameServices {

    @GET("api/games")
    fun fetchGames(
        @Query("page_size") pageSize: Int? = ApiConstants.pageSize,
        @Query("page") page: Int? = ApiConstants.page
    ): Single<ApiResponse<List<Game>>>

    @GET
    fun getGameDetail(
        @Query("") id: Int?
    ): Single<ApiResponse<GameDetail>>
}