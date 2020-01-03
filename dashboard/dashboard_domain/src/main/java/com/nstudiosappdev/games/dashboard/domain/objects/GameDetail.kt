package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("released") val released: String?,
    @SerializedName("background_image") val backgroundImage: String?,
    @SerializedName("background_image_additional") val backgroundImageAdditional: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("ratings_count") val ratingsCount: Int?,
    @SerializedName("reviews_count") val reviewsCount: Int?
)

data class Reaction(
    @SerializedName("1") val reaction1: Int?,
    @SerializedName("2") val reaction2: Int?,
    @SerializedName("3") val reaction3: Int?,
    @SerializedName("4") val reaction4: Int?,
    @SerializedName("5") val reaction5: Int?,
    @SerializedName("6") val reaction6: Int?,
    @SerializedName("7") val reaction7: Int?,
    @SerializedName("8") val reaction8: Int?,
    @SerializedName("9") val reaction9: Int?,
    @SerializedName("10") val reaction10: Int?,
    @SerializedName("11") val reaction11: Int?,
    @SerializedName("12") val reaction12: Int?,
    @SerializedName("13") val reaction13: Int?,
    @SerializedName("14") val reaction14: Int?,
    @SerializedName("15") val reaction15: Int?,
    @SerializedName("16") val reaction16: Int?,
    @SerializedName("17") val reaction17: Int?,
    @SerializedName("18") val reaction18: Int?,
    @SerializedName("19") val reaction19: Int?,
    @SerializedName("20") val reaction20: Int?,
    @SerializedName("21") val reaction21: Int?
)

data class EsrbRating(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug :String?
)
