package com.nstudiosappdev.core.navigation.features

import android.content.Intent
import com.nstudiosappdev.core.navigation.PACKAGE_NAME
import com.nstudiosappdev.core.navigation.loadIntentOrReturnNull

object Dashboard : Feature<Intent> {

    private const val MAIN = "$PACKAGE_NAME.dashboard.presentation.DashboardActivity"

    override val dynamicStart: Intent?
        get() = MAIN.loadIntentOrReturnNull()
}
