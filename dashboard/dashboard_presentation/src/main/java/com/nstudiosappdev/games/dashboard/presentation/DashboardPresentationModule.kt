package com.nstudiosappdev.games.dashboard.presentation

import com.nstudiosappdev.core.presentation.recyclerview.*
import dagger.Module
import dagger.Provides

@Module
abstract class DashboardPresentationModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDisplayItemComparator(): DisplayItemComparator = DefaultDisplayItemComparator()

        @JvmStatic
        @Provides
        fun provideRecyclerAdapter(
            itemComparator: DisplayItemComparator,
            factoryMap: Map<Int, @JvmSuppressWildcards ViewHolderFactory>,
            binderMap: Map<Int, @JvmSuppressWildcards ViewHolderBinder>
        ): RecyclerViewAdapter {
            return RecyclerViewAdapter(
                itemComparator = itemComparator,
                viewHolderFactoryMap = factoryMap,
                viewBinderFactoryMap = binderMap
            )
        }
    }
}