package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import androidx.lifecycle.ViewModel
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.core.presentation.viewmodel.ViewModelKey
import com.nstudiosappdev.games.dashboard.domain.objects.GameDetail
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.functions.Function

@Module
abstract class GameDetailViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GameDetailViewModel::class)
    abstract fun bindGameDetailViewModel(gameDetailViewModel: GameDetailViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGameDetailViewEntityMapper(): Function<GameDetail, DisplayItem> = GameDetailViewEntityMapper()
    }
}