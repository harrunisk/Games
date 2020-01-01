package com.nstudiosappdev.games.injection.modules

import android.content.Context
import com.nstudiosappdev.core.injection.modules.CoreModule
import com.nstudiosappdev.games.GamesApp
import dagger.Module
import dagger.Provides

@Module(
    includes = [CoreModule::class]
)
class ApplicationModule {

    @Provides
    fun provideApplicationContext(app: GamesApp): Context {
        return app.applicationContext
    }
}
