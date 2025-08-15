package com.jinen.intelli.rewards_for_children.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jinen.intelli.rewards_for_children.data.model.Reward
import kotlinx.coroutines.flow.Flow

@Dao
interface RewardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reward: Reward)

    @Update
    suspend fun update(reward: Reward)

    @Delete
    suspend fun delete(reward: Reward)

    @Query("SELECT * FROM rewards WHERE id = :id")
    fun getReward(id: Int): Flow<Reward>

    @Query("SELECT * FROM rewards ORDER BY date DESC")
    fun getAllRewards(): Flow<List<Reward>>
}
