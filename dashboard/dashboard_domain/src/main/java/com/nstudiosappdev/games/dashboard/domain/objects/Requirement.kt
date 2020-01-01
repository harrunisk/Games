package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class Requirement(
    @SerializedName("minimum") val minimum: String?,
    @SerializedName("recommended") val recommended: String?
)