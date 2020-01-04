package com.nstudiosappdev.games.dashboard.presentation

import android.os.Bundle
import com.nstudiosappdev.core.navigation.navigation.DefaultNavigationController
import com.nstudiosappdev.core.presentation.base.BaseActivity
import com.nstudiosappdev.core.presentation.navigation.UiNavigation
import java.lang.ref.WeakReference

class DashboardActivity : BaseActivity() {

    private lateinit var navigationController: DefaultNavigationController

    override val uiNavigation: UiNavigation = UiNavigation.ROOT

    override fun getLayoutRes(): Int = R.layout.activity_dashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(this))

        navigationController.navigateToDashboardFragment(R.id.fl_main)
        navigationController.navigateToBottomNavigation(R.id.fl_bottom_navigation)
    }

}