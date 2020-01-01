package com.nstudiosappdev.games.injection.components

import com.nstudiosappdev.games.GamesApp
import com.nstudiosappdev.games.injection.modules.*
import com.nstudiosappdev.games.injection.modules.ActivityModule
import com.nstudiosappdev.games.injection.modules.DataModule
import com.nstudiosappdev.games.injection.modules.DomainModule
import com.nstudiosappdev.games.injection.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DomainModule::class,
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GamesApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: GamesApp)
}