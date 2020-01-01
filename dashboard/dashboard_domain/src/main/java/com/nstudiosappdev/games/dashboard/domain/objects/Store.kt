package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id") val id: Int?,
    @SerializedName("store") val store: List<StoreDetail?>?,
    @SerializedName("url") val url :String?,
    @SerializedName("url_en") val urlEn: String?,
    @SerializedName("url_ru") val urlRu: String?
)