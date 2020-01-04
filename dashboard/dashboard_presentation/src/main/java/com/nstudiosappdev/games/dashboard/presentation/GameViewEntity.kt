package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.presentation.entity.ViewEntity
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.objects.Genre

class GameViewEntity(
    val id: Int?,
    val name: String?,
    val released: String?,
    val backgroundImage: String?,
    val rating: Double?,
    val genre: List<Genre>?
) : ViewEntity, DisplayItem {

    override fun type(): Int =
        GamePresentationConstants.TYPES.GAME
}
