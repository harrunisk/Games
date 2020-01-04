package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.objects.Game
import io.reactivex.functions.Function

class GameViewEntityMapper : Function<Game, DisplayItem> {

    override fun apply(t:Game): DisplayItem{
        return GameViewEntity(
            id = t.id,
            name = t.name,
            released = t.released,
            backgroundImage = t.backgroundImage,
            rating = t.rating,
            genre = t.genres
        )
    }

}
