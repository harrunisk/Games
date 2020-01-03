package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import io.reactivex.functions.Function

class GameDetailViewEntityMapper : Function<GameDetail, DisplayItem> {

    override fun apply(t: GameDetail): DisplayItem {
        return GameDetailViewEntity(
            id = t.id,
            name = t.name,
            description = t.description,
            release = t.released,
            backgroundImage = t.backgroundImage,
            backgroundImageAdditional = t.backgroundImageAdditional,
            website = t.website,
            rating = t.rating,
            ratingsCount = t.ratingsCount,
            reviewCounts = t.reviewsCount
        )
    }
}