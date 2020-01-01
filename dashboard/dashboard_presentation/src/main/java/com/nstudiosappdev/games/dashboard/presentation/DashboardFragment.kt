package com.nstudiosappdev.games.dashboard.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nstudiosappdev.core.presentation.base.BaseFragment
import javax.inject.Inject

class DashboardFragment : BaseFragment() {

    @Inject
    protected lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var viewModelDashboard: DashboardViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_dashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelDashboard =
            ViewModelProviders.of(this, vmFactory).get(DashboardViewModel::class.java)
    }
}