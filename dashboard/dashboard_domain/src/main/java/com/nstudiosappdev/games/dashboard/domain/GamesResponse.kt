package com.nstudiosappdev.games.dashboard.domain

import com.google.gson.annotations.SerializedName
import com.nstudiosappdev.games.dashboard.domain.objects.Game

class GamesResponse (
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<Game>?
)