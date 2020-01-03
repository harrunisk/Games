package com.nstudiosappdev.core.navigation.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nstudiosappdev.core.navigation.PACKAGE_NAME
import com.nstudiosappdev.core.navigation.loadFragmentOrReturnNull

object GameDetailFragment : Feature<Fragment> {

    const val BUNDLE_GAME_ID = "game_id"

    private const val BIT_COIN_MARKET_PRICE_FRAGMENT =
        "$PACKAGE_NAME.dashboard.presentation.gamedetail.GameDetailFragment"

    override val dynamicStart: Fragment?
        get() = BIT_COIN_MARKET_PRICE_FRAGMENT.loadFragmentOrReturnNull()

    fun dynamicStartWithGameId(
        gameId: Int
    ): Fragment? {
        return dynamicStart?.apply {
            val bundle = Bundle()
            bundle.putInt(BUNDLE_GAME_ID, gameId)
            arguments = bundle
        }

    }
}
