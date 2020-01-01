package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.injection.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [DashboardFragmentModule::class]
    )

    abstract fun provideDashboardActivity(): DashboardActivity
}