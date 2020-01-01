package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("platform") val platform: List<PlatformDetail?>?,
    @SerializedName("released_at") val releasedAt: String?,
    @SerializedName("requirements") val requirement: Requirement?,
    @SerializedName("requirements_en") val requirementsEn: Requirement?,
    @SerializedName("requirements_ru") val requirementsRu: Requirement?
)