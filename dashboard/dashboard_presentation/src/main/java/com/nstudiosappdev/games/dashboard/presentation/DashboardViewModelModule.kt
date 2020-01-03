package com.nstudiosappdev.games.dashboard.presentation

import androidx.lifecycle.ViewModel
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.core.presentation.viewmodel.ViewModelKey
import com.nstudiosappdev.games.dashboard.domain.objects.Game
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.functions.Function

@Module
abstract class DashboardViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGameViewEntityMapper(): Function<Game, DisplayItem> =
            GameViewEntityMapper()
    }
}