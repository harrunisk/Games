package com.nstudiosappdev.games.injection.modules

import com.nstudiosappdev.core.data.injection.modules.ApiModule
import dagger.Module

@Module(
    includes = [ApiModule::class]
)
internal abstract class DataModule