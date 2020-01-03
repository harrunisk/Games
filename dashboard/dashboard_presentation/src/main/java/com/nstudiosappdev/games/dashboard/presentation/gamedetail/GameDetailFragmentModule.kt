package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import com.nstudiosappdev.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GameDetailFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeGameDetailFragmentInjector(): GameDetailFragment
}