package com.jinen.intelli.rewards_for_children

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jinen.intelli.rewards_for_children.data.local.AppDatabase
import com.jinen.intelli.rewards_for_children.data.local.RewardDao
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.data.model.RewardType
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class RewardDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var rewardDao: RewardDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        rewardDao = database.rewardDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAndGetReward() = runBlocking {
        val reward = Reward(id = 1, title = "Test", description = "Test Desc", points = 10, type = RewardType.REWARD)
        rewardDao.insert(reward)
        val allRewards = rewardDao.getAllRewards().first()
        assert(allRewards.contains(reward))
    }
}
