package com.nstudiosappdev.games.dashboard.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.common.truth.Truth
import com.nstudiosappdev.core.error.DefaultErrorFactory
import com.nstudiosappdev.core.error.ErrorConstants
import com.nstudiosappdev.core.error.ErrorFactory
import com.nstudiosappdev.core.model.DataHolder
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.games.dashboard.domain.GameDetailInteractor
import com.nstudiosappdev.games.dashboard.presentation.gamedetail.GameDetailViewEntityMapper
import com.nstudiosappdev.games.dashboard.presentation.gamedetail.GameDetailViewModel
import com.nstudiosappdev.games.dashboard.presentation.testutils.DataProvider
import com.nstudiosappdev.games.dashboard.presentation.testutils.RxSchedulerOverrideRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.spyk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameDetailViewModelTest {

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
     * Mocked [GameDetailInteractor] that we will use to test
     * [GameDetailViewModel].
     */

    @MockK
    private lateinit var gameDetailInteractor: GameDetailInteractor

    /**
     * Mocked [GameViewEntityMapper] that we will use to test
     * [GameDetailViewModel].
     */

    @RelaxedMockK
    private lateinit var gameDetailViewEntityMapper: GameDetailViewEntityMapper

    /**
     * Mocked [ErrorFactory] that we will use to test
     * [GameDetailViewModel].
     */
    @MockK
    private lateinit var errorFactory: ErrorFactory

    /**
     * Instance of the class that we want to test.
     */
    private lateinit var viewModel: GameDetailViewModel

    private fun createGameDetailObserver(): Observer<DataHolder<DisplayItem>> =
        spyk(Observer { })

    /**
     * Setting up what we need for the tests.
     */
    @Before
    fun setUp() {

        // Instantiating the @MockK annotated variables.
        MockKAnnotations.init(this, relaxUnitFun = true)
        // Instantiating the class that we want to test.
        viewModel = GameDetailViewModel(
            gameDetailInteractor,
            gameDetailViewEntityMapper,
            errorFactory
        )
    }

    @Test
    fun `given loading state, when getGameDetail called, then update live data for loading status`() {

        //given
        val mockerObserver = createGameDetailObserver()

        viewModel.gameDetailLiveData
            .observeForever(mockerObserver)

        every { gameDetailInteractor.execute(any()) } returns
                Observable.just(DataProvider.createGameDetail())

        // when
        viewModel.getGameDetail(4268)

        // then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[0]).isInstanceOf(DataHolder.Loading::class.java)
    }

    @Test
    fun `given success state, when getGameDetail called, then update live data for success status`() {
        //given
        val mockerObserver = createGameDetailObserver()

        viewModel.gameDetailLiveData
            .observeForever(mockerObserver)

        every { gameDetailInteractor.execute(any()) } returns
                Observable.just(DataProvider.createGameDetail())


        // when
        viewModel.getGameDetail(4268)

        //then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[1]).isInstanceOf(DataHolder.Success::class.java)
    }

    @Test
    fun `given error state, when getGameDetail called, then update live data for error status`() {
        //given
        val mockerObserver = createGameDetailObserver()

        viewModel.gameDetailLiveData
            .observeForever(mockerObserver)

        every { gameDetailInteractor.execute(any()) } returns
                Observable.just(
                    DataHolder.Fail(
                        DefaultErrorFactory().createApiError(
                            ErrorConstants.API_ERROR_CODE,
                            ErrorConstants.API_ERROR_MESSAGE
                        )
                    )
                )


        // when
        viewModel.getGameDetail(4268)

        //then
        val executionStateSlots = mutableListOf<DataHolder.Loading>()
        verify { mockerObserver.onChanged(capture(executionStateSlots)) }

        Truth.assertThat(executionStateSlots[1]).isInstanceOf(DataHolder.Fail::class.java)
    }
}