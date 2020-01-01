package com.nstudiosappdev.games.injection.modules

import com.nstudiosappdev.core.injection.scope.ActivityScope
import com.nstudiosappdev.games.dashboard.presentation.DashboardActivityModule
import com.nstudiosappdev.games.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [DashboardActivityModule::class]
)
internal abstract class ActivityModule {
    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributeMainActivityInjector(): MainActivity
}
