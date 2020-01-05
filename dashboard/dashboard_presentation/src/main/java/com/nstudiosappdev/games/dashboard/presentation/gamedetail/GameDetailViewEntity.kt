package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import com.nstudiosappdev.core.presentation.entity.ViewEntity
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.presentation.GamePresentationConstants

class GameDetailViewEntity(
    val id: Int?,
    val name: String?,
    val description: String?,
    val release: String?,
    val backgroundImage: String?,
    val rating: Double?
) : ViewEntity, DisplayItem {
    override fun type(): Int = GamePresentationConstants.TYPES.GAME_DETAIL

}