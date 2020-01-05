package com.nstudiosappdev.games.dashboard.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.common.truth.Truth
import com.nstudiosappdev.core.error.DefaultErrorFactory
import com.nstudiosappdev.core.error.ErrorConstants.Companion.API_ERROR_CODE
import com.nstudiosappdev.core.error.ErrorConstants.Companion.API_ERROR_MESSAGE
import com.nstudiosappdev.core.error.ErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.GamesInteractor
import com.nstudiosappdev.games.dashboard.presentation.testutils.DataProvider.Companion.createGames
import com.nstudiosappdev.games.dashboard.presentation.testutils.RxSchedulerOverrideRule
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DashboardViewModelTest {

    /**
     * Rule that swaps the background executor used by the Architecture Components with a different
     * one which executes each task synchronously.
     */
    @get:Rule
    val architectureComponentsTestRule = InstantTaskExecutorRule()

    /**
     * Rule that swaps the background executors used by RxJava2 with a different one which executes
     * each task synchronously.
     */
    @get:Rule
    val rxJavaTestRule = RxSchedulerOverrideRule()

    /**
     * Mocked [GamesInteractor] that we will use to test
     * [DashboardViewModel].
     */

    @MockK
    private lateinit var gamesInteractor: GamesInteractor

    /**
     * Mocked [GameViewEntityMapper] that we will use to test
     * [DashboardViewModel].
     */

    @RelaxedMockK
    private lateinit var gameViewEntityMapper: GameViewEntityMapper

    /**
     * Mocked [ErrorFactory] that we will use to test
     * [DashboardViewModel].
     */
    @MockK
    private lateinit var errorFactory: ErrorFactory

    /**
     * Instance of the class that we want to test.
     */
    private lateinit var viewModel: DashboardViewModel

    private fun createGameObserver(): Observer<DataHolder<List<DisplayItem>>> =
        spyk(Observer { })

    /**
     * Setting up what we need for the tests.
     */
    @Before
    fun setUp() {

        // Instantiating the @MockK annotated variables.
        MockKAnnotations.init(this, relaxUnitFun = true)
        // Instantiating the class that we want to test.
        viewModel = DashboardViewModel(
            gamesInteractor,
            gameViewEntityMapper,
            errorFactory
        )
    }

    @Test
    fun `given loading state, when getGames called, then update live data for loading status`() {

        //given
        val mockerObserver = createGameObserver()

        viewModel.gamesLiveData
            .observeForever(mockerObserver)

        every { gamesInteractor.execute(any()) } returns
                Observable.just(createGames())

        // when
        viewModel.getGames(1, 1)

        // then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[1]).isInstanceOf(DataHolder.Loading::class.java)
    }

    @Test
    fun `given success state, when getGames called, then update live data for success status`() {
        //given
        val mockerObserver = createGameObserver()

        viewModel.gamesLiveData
            .observeForever(mockerObserver)

        every { gamesInteractor.execute(any()) } returns
                Observable.just(createGames())


        // when
        viewModel.getGames(1, 1)

        //then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[0]).isInstanceOf(DataHolder.Success::class.java)
    }

    @Test
    fun `given error state, when getGames called, then update live data for error status`() {
        //given
        val mockerObserver = createGameObserver()

        viewModel.gamesLiveData
            .observeForever(mockerObserver)

        every { gamesInteractor.execute(any()) } returns
                Observable.just(
                    DataHolder.Fail(
                        DefaultErrorFactory().createApiError(
                            API_ERROR_CODE,
                            API_ERROR_MESSAGE
                        )
                    )
                )


        // when
        viewModel.getGames(null, null)

        //then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[2]).isInstanceOf(DataHolder.Fail::class.java)
    }
}