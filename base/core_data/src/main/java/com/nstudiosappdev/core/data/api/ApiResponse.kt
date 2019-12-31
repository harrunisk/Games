package com.nstudiosappdev.core.data.api

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: T?
)
