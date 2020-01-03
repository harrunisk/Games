package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.injection.scope.ActivityScope
import com.nstudiosappdev.games.dashboard.presentation.gamedetail.GameDetailFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [DashboardFragmentModule::class,
            GameDetailFragmentModule::class]
    )

    abstract fun provideDashboardActivity(): DashboardActivity
}