package com.nstudiosappdev.games.dashboard.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.navigation.navigation.DefaultNavigationController
import com.nstudiosappdev.core.presentation.base.BaseFragment
import com.nstudiosappdev.core.presentation.extensions.setup
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.core.presentation.recyclerview.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.lang.ref.WeakReference
import javax.inject.Inject

class DashboardFragment : BaseFragment() {

    private lateinit var navigationController: DefaultNavigationController

    @Inject
    protected lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var viewModelDashboard: DashboardViewModel

    @Inject
    protected lateinit var gamesAdapter: RecyclerViewAdapter

    private val itemClickListener = { _: View, item: DisplayItem ->
        navigationController.navigateToGameDetailFragment(
            R.id.fl_main,
            (item as GameViewEntity).id!!
        )
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = recyclerViewGames.childCount
            val totalItemCount = recyclerViewGames.layoutManager?.itemCount ?: 0
            val firstVisibleItemPosition =
                (recyclerViewGames.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            if (viewModelDashboard.gamesLiveData.value !is DataHolder.Loading) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 5 && firstVisibleItemPosition >= 0) {
                    viewModelDashboard.getGamesByPagination()
                }
            }
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_dashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelDashboard =
            ViewModelProviders.of(this, vmFactory).get(DashboardViewModel::class.java)
        this.navigationController = DefaultNavigationController(WeakReference(activity!!))
    }

    override fun initView() {
        super.initView()
        recyclerViewGames.apply {
            setup(
                context = context!!,
                adapter = gamesAdapter
            )
            addOnScrollListener(recyclerViewOnScrollListener)
        }
        gamesAdapter.itemClickListener = this.itemClickListener
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelDashboard.gamesLiveData.observe(this, Observer {
            swipeToRefreshLayout.isRefreshing = it is DataHolder.Loading
            when (it) {
                is DataHolder.Success -> {
                    gamesAdapter.addItems(it.data)
                }
                is DataHolder.Fail -> {
                    onError(it.e)
                }
            }

        })

        if (savedInstanceState == null) {
            viewModelDashboard.getGamesByPagination()
        }
    }
}