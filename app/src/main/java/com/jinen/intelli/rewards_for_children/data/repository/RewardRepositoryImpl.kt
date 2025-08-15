package com.jinen.intelli.rewards_for_children.data.repository

import com.jinen.intelli.rewards_for_children.data.local.RewardDao
import com.jinen.intelli.rewards_for_children.data.model.Reward
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RewardRepositoryImpl @Inject constructor(
    private val rewardDao: RewardDao
) : RewardRepository {
    override fun getAllRewards(): Flow<List<Reward>> = rewardDao.getAllRewards()
    override fun getReward(id: Int): Flow<Reward> = rewardDao.getReward(id)
    override suspend fun insertReward(reward: Reward) = rewardDao.insert(reward)
    override suspend fun updateReward(reward: Reward) = rewardDao.update(reward)
    override suspend fun deleteReward(reward: Reward) = rewardDao.delete(reward)
}
