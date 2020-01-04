package com.nstudiosappdev.core.presentation.extensions

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout

fun AppCompatActivity.simpleToolbarWithHome(toolbar: Toolbar, title_: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        setDisplayHomeAsUpEnabled(true)
        title = title_
    }
}

fun AppCompatActivity.applyToolbarMargin(toolbar: Toolbar) {
    if (checkIsMaterialVersion()) {
        toolbar.layoutParams = (toolbar.layoutParams as CollapsingToolbarLayout.LayoutParams).apply {
            topMargin = getStatusBarSize()
        }
    }
}

private fun AppCompatActivity.getStatusBarSize(): Int {
    val idStatusBarHeight = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (idStatusBarHeight > 0) {
        resources.getDimensionPixelSize(idStatusBarHeight)
    } else 0
}

fun checkIsMaterialVersion() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
