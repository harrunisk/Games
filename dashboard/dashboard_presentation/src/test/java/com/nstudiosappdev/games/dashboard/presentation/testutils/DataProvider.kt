package com.nstudiosappdev.games.dashboard.presentation.testutils

import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.games.dashboard.domain.GamesResponse
import com.nstudiosappdev.games.dashboard.domain.objects.Game
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail

class DataProvider {

    companion object {
        fun createGames(): DataHolder<GamesResponse> {

            val gameFirst = Game(
                id = 3498,
                name = "Grand Theft Auto V",
                released = "2013-09-17",
                backgroundImage = "https://media.rawg.io/media/games/b11/b115b2bc6a5957a917bc7601f4abdda2.jpg",
                rating = 4.48
            )

            val gameSecond = Game(
                id = 4200,
                name = "portal-2",
                released = "2011-04-19",
                backgroundImage = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                rating = 4.6
            )

            val gameMockList: List<Game> = arrayListOf(gameFirst, gameSecond)

            return DataHolder.Success(
                GamesResponse(
                    count = 353650,
                    next = "https://api.rawg.io/api/games?page=2&page_size=10",
                    previous = null,
                    results = gameMockList
                )
            )
        }

        fun createGameDetail(): DataHolder<GameDetail> {
            return DataHolder.Success(
                GameDetail(
                    id = 3498,
                    name = "Grand Theft Auto V",
                    released = "2013-09-17",
                    description = "<p>Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate) and the amount is rising with every update. <br />\\nSimultaneous storytelling from three unique perspectives: <br />\\nFollow Michael, ex-criminal living his life of leisure away from the past, Franklin, a kid that seeks the better future, and Trevor, the exact past Michael is trying to run away from. <br />\\nGTA Online will provide a lot of additional challenge even for the experienced players, coming fresh from the story mode. Now you will have other players around that can help you just as likely as ruin your mission. Every GTA mechanic up to date can be experienced by players through the unique customizable character, and community content paired with the leveling system tends to keep everyone busy and engaged.</p>",
                    backgroundImage = "https://media.rawg.io/media/games/b11/b115b2bc6a5957a917bc7601f4abdda2.jpg",
                    backgroundImageAdditional = "https://media.rawg.io/media/screenshots/5f5/5f5a38a222252d996b18962806eed707.jpg",
                    website = "http://www.rockstargames.com/V/",
                    rating = 4.48,
                    ratingsCount = 5,
                    reviewsCount = 2929
                )
            )

        }
    }
}