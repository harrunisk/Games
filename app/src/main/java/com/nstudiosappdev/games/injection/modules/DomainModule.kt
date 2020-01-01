package com.nstudiosappdev.games.injection.modules

import com.nstudiosappdev.games.dashboard.domain.GameDomainModule
import dagger.Module

@Module(
    includes = [GameDomainModule::class]
)
internal abstract class DomainModule