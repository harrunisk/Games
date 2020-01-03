package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.presentation.entity.ViewEntity
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem

class GameViewEntity(
    val id: Int?,
    val name: String?,
    val released: String?,
    val backgroundImage: String?,
    val rating: Double?
) : ViewEntity, DisplayItem {

    override fun type(): Int =
        GamePresentationConstants.TYPES.GAME
}
