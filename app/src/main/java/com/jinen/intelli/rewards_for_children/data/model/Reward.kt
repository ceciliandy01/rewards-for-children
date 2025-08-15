package com.jinen.intelli.rewards_for_children.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rewards")
data class Reward(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val points: Int,
    val type: RewardType,
    val date: Long = System.currentTimeMillis()
)

enum class RewardType {
    REWARD,
    PUNISHMENT
}
