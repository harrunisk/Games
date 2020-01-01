package com.nstudiosappdev.games.injection.modules

import com.nstudiosappdev.core.data.injection.modules.ApiModule
import com.nstudiosappdev.games.dashboard.data.GameDataModule
import dagger.Module

@Module(
    includes = [ApiModule::class,
        GameDataModule::class]
)
internal abstract class DataModule