package com.jinen.intelli.rewards_for_children.data.repository

import com.jinen.intelli.rewards_for_children.data.model.Reward
import kotlinx.coroutines.flow.Flow

interface RewardRepository {
    fun getAllRewards(): Flow<List<Reward>>
    fun getReward(id: Int): Flow<Reward>
    suspend fun insertReward(reward: Reward)
    suspend fun updateReward(reward: Reward)
    suspend fun deleteReward(reward: Reward)
}
