package com.nstudiosappdev.core.injection.modules

import com.nstudiosappdev.core.date.DateTimeConverter
import com.nstudiosappdev.core.date.DefaultDateTimeConverter
import com.nstudiosappdev.core.error.DefaultErrorFactory
import com.nstudiosappdev.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    internal fun provideErrorFactory(): ErrorFactory = DefaultErrorFactory()

    @Provides
    @Singleton
    fun provideDateTimeConverter(): DateTimeConverter = DefaultDateTimeConverter()
}
