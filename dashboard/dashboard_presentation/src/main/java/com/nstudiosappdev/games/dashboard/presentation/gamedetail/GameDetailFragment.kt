package com.nstudiosappdev.games.dashboard.presentation.gamedetail

import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.navigation.features.GameDetailFragment.BUNDLE_GAME_ID
import com.nstudiosappdev.core.presentation.base.BaseFragment
import com.nstudiosappdev.core.presentation.extensions.loadImage
import com.nstudiosappdev.games.dashboard.presentation.R
import kotlinx.android.synthetic.main.fragment_game_detail.*
import kotlinx.android.synthetic.main.layout_game_detail_body.*
import kotlinx.android.synthetic.main.layout_game_detail_header.*
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelGameDetail.gameDetailLiveData.observe(this, Observer {
            when (it) {
                is DataHolder.Success -> {
                    initUi((it.data as GameDetailViewEntity))

                }
                is DataHolder.Fail -> {
                    onError(it.e)
                }
            }
        })

    }

    private fun initUi(gameDetailViewEntity: GameDetailViewEntity) {


        // Detail fragment
        game_detail_background.loadImage(gameDetailViewEntity.backgroundImage!!)

        // Header
        detail_header_title.text = gameDetailViewEntity.name
        detail_header_release.text = gameDetailViewEntity.release
        detail_header_star.rating = gameDetailViewEntity.rating!!.toFloat()

        // Body
        detail_body_description.text =
            HtmlCompat.fromHtml(gameDetailViewEntity.description!!, HtmlCompat.FROM_HTML_MODE_COMPACT)

    }

}