package com.nstudiosappdev.core.navigation.features

import androidx.fragment.app.Fragment
import com.nstudiosappdev.core.navigation.PACKAGE_NAME
import com.nstudiosappdev.core.navigation.loadFragmentOrReturnNull

object BottomNavigation : Feature<Fragment> {

    private const val BOTTOM_NAVIGATION =
        "$PACKAGE_NAME.dashboard.presentation.bottomnavigation.BottomNavigationFragment"

    override val dynamicStart: Fragment?
        get() = BOTTOM_NAVIGATION.loadFragmentOrReturnNull()
}
