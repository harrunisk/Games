package com.nstudiosappdev.core.navigation.navigation

import androidx.fragment.app.FragmentActivity
import com.nstudiosappdev.core.navigation.features.BottomNavigation
import com.nstudiosappdev.core.navigation.features.Dashboard
import com.nstudiosappdev.core.navigation.features.DashboardFragment
import com.nstudiosappdev.core.navigation.features.GameDetailFragment
import java.lang.ref.WeakReference

class DefaultNavigationController constructor(
    override val activity: WeakReference<FragmentActivity>
) : NavigationController {

    override fun navigateToDashboardFragment(containerId: Int) =
        start(DashboardFragment.dynamicStart,
            containerId, transaction = {
                replace(containerId, DashboardFragment.dynamicStart!!).addToBackStack(null)
            })

    override fun navigateToDashboard() = start(Dashboard.dynamicStart)

    override fun navigateToGameDetailFragment(containerId: Int, gameId: Int) =
        start(
            GameDetailFragment.dynamicStartWithGameId(gameId),
            containerId,
            transaction = {
                replace(
                    containerId,
                    GameDetailFragment.dynamicStartWithGameId(gameId)!!
                ).addToBackStack(null)
            })

    override fun navigateToBottomNavigation(containerId: Int) =
        start(BottomNavigation.dynamicStart,
            containerId, transaction = {
                replace(containerId, BottomNavigation.dynamicStart!!).addToBackStack(null)
            })

}
