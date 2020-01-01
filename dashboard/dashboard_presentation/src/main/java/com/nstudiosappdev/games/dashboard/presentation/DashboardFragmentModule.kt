package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [DashboardPresentationModule::class])
    abstract fun contributeDashboardFragmentInjector(): DashboardFragment
}