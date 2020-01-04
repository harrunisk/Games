package com.nstudiosappdev.games.dashboard.presentation.bottomnavigation

import com.nstudiosappdev.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BottomNavigationFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeBottomNavigationFragmentInjector(): BottomNavigationFragment
}