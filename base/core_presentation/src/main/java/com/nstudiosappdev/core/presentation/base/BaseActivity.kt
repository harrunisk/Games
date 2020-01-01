package com.nstudiosappdev.core.presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.nstudiosappdev.core.presentation.Constants
import com.nstudiosappdev.core.presentation.R
import com.nstudiosappdev.core.presentation.navigation.UiNavigation
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    @StringRes
    open val titleRes = R.string.app_name

    @MenuRes
    open val menuRes = Constants.NO_RES

    open val uiNavigation = UiNavigation.BACK

    @IdRes
    open val toolbarRes = Constants.NO_RES

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        onInject()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        if (toolbarRes != Constants.NO_RES) {
            setToolbar(findViewById(toolbarRes))
        }
        initNavigation(uiNavigation)
        setScreenTitle(getString(titleRes))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menuRes != Constants.NO_RES) {
            menuInflater.inflate(menuRes, menu)
            return true
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    fun setScreenTitle(title: String?) {
        supportActionBar?.title = title
    }

    private fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    private fun initNavigation(uiNavigation: UiNavigation) {
        when (uiNavigation) {
            UiNavigation.BACK -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
            UiNavigation.ROOT -> supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    open fun onInject() {
        // can be overridden
    }
}
