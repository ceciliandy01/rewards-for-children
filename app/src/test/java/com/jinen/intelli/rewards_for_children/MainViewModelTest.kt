package com.jinen.intelli.rewards_for_children

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.data.model.RewardType
import com.jinen.intelli.rewards_for_children.data.repository.RewardRepository
import com.jinen.intelli.rewards_for_children.ui.viewmodel.MainViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: RewardRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()
        val rewards = listOf(
            Reward(1, "Reward", "Test", 10, RewardType.REWARD, System.currentTimeMillis()),
            Reward(2, "Punishment", "Test", -5, RewardType.PUNISHMENT, System.currentTimeMillis())
        )
        coEvery { repository.getAllRewards() } returns flowOf(rewards)
        viewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test if viewmodel initializes with rewards`() = runTest {
        val rewards = viewModel.rewards.value
        assert(rewards.size == 2)
    }
}
