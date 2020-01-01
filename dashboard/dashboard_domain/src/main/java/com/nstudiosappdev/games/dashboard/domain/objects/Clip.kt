package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class Clip(
    @SerializedName("clip") val clip: String?,
    @SerializedName("clips") val clips: ClipDetail?,
    @SerializedName("video") val video: String?,
    @SerializedName("preview") val preview: String?
)

data class ClipDetail(
    @SerializedName("320") val minResolution: String?,
    @SerializedName("640") val midResolution: String?,
    @SerializedName("full") val fulResolution: String?
)

data class ScreenShot(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?
)