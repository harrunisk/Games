package com.nstudiosappdev.games.injection.modules

import androidx.lifecycle.ViewModelProvider
import com.nstudiosappdev.core.presentation.viewmodel.VmFactory
import com.nstudiosappdev.games.dashboard.presentation.DashboardViewModelModule
import dagger.Binds
import dagger.Module

@Module(includes = [DashboardViewModelModule::class])
internal abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(vmFactory: VmFactory): ViewModelProvider.Factory
}