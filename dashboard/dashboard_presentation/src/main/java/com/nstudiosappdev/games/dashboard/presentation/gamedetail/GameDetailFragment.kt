package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nstudiosappdev.core.navigation.features.GameDetailFragment.BUNDLE_GAME_ID
import com.nstudiosappdev.core.presentation.base.BaseFragment
import com.nstudiosappdev.games.dashboard.presentation.R
import javax.inject.Inject

class GameDetailFragment : BaseFragment() {

    private var gameId: Int? = null

    @Inject
    protected lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var viewModelGameDetail: GameDetailViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_game_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelGameDetail =
            ViewModelProviders.of(this, vmFactory).get(GameDetailViewModel::class.java)

        arguments?.let {
            gameId = it.getInt(BUNDLE_GAME_ID)
            viewModelGameDetail.getGameDetail(gameId!!)
        }

    }

}