package com.nstudiosappdev.games.dashboard.domain.objects

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("id") val id: Int?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("released") val released: String?,
    @SerializedName("tba") val tba: Boolean?,
    @SerializedName("background_image") val backgroundImage: String?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("rating_top") val ratingTop: Double?,
    @SerializedName("ratings") val ratings: List<Rating>?,
    @SerializedName("ratings_count") val ratingsCount: Int?,
    @SerializedName("reviews_text_count") val reviewsTextCount: Int?,
    @SerializedName("added") val added: Int?,
    @SerializedName("added_by_status") val addedByStatus: AddedByStatus?,
    @SerializedName("metacritic") val metaCritic: Int?,
    @SerializedName("playTime") val playTime: Int?,
    @SerializedName("suggestion_count") val suggestionCount: Int?,
    @SerializedName("user_game") val userGame: String?,
    @SerializedName("reviews_count") val reviewsCount: Int?,
    @SerializedName("saturatedColor") val saturatedColor: String?,
    @SerializedName("dominantColor") val dominantColor: String?,
    @SerializedName("platforms") val platforms: Platform?,
    @SerializedName("parent_platforms") val parentPlatforms: PlatformDetail?,
    @SerializedName("genres") val genres: List<Genre?>?,
    @SerializedName("stores") val stores: List<Store?>?,
    @SerializedName("clip") val clip: Clip?,
    @SerializedName("short_screenshots") val shortScreenshots: List<ScreenShot?>?
)