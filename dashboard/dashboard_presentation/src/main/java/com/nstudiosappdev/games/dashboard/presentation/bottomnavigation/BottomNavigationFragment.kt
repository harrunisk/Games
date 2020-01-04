package com.nstudiosappdev.games.dashboard.presentation.bottomnavigation

import android.os.Bundle
import com.nstudiosappdev.core.navigation.navigation.DefaultNavigationController
import com.nstudiosappdev.core.presentation.base.BaseFragment
import com.nstudiosappdev.games.dashboard.presentation.R
import java.lang.ref.WeakReference

class BottomNavigationFragment : BaseFragment() {

    lateinit var navigationController: DefaultNavigationController

    override fun getLayoutRes() = R.layout.fragment_bottom_navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(activity!!))
    }
}