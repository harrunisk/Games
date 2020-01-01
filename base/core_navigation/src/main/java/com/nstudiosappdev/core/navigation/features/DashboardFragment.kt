package com.nstudiosappdev.core.navigation.features

import androidx.fragment.app.Fragment
import com.nstudiosappdev.core.navigation.PACKAGE_NAME
import com.nstudiosappdev.core.navigation.loadFragmentOrReturnNull

object DashboardFragment : Feature<Fragment> {

    private const val BIT_COIN_MARKET_PRICE_FRAGMENT =
        "$PACKAGE_NAME.dashboard.presentation.DashboardFragment"

    override val dynamicStart: Fragment?
        get() = BIT_COIN_MARKET_PRICE_FRAGMENT.loadFragmentOrReturnNull()
}
