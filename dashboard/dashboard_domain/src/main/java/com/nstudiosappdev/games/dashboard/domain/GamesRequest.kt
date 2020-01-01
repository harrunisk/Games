package com.nstudiosappdev.games.dashboard.domain

import com.google.gson.annotations.SerializedName

class GamesRequest (
    @SerializedName("page") val page: Int?,
    @SerializedName("pageSize") val pageSize: Int?
)