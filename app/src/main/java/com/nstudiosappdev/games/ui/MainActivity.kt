package com.nstudiosappdev.games.ui

import android.os.Bundle
import com.nstudiosappdev.core.navigation.navigation.DefaultNavigationController
import com.nstudiosappdev.core.navigation.navigation.NavigationController
import com.nstudiosappdev.core.presentation.base.BaseActivity
import com.nstudiosappdev.core.presentation.navigation.UiNavigation
import com.nstudiosappdev.games.R
import java.lang.ref.WeakReference

class MainActivity : BaseActivity() {

    private lateinit var navigationController: NavigationController

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val uiNavigation = UiNavigation.ROOT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(this))

        navigationController.navigateToDashboard()
    }
}
